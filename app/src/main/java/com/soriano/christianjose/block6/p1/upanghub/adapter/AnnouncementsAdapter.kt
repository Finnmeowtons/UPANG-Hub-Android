package com.soriano.christianjose.block6.p1.upanghub.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.soriano.christianjose.block6.p1.upanghub.databinding.ItemAnnouncementsBinding

class AnnouncementsAdapter() : RecyclerView.Adapter<AnnouncementsViewHolder>() {


    var announcements: List<String> = listOf(
        "https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid0DHV4wQ9EDoNky9LxoLebP2WMWLeps1e1a862wwkugCBSzWdkTC9YR4z8xDvjUTvdl&show_text=true&width=300",
        "https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid02pAAVq2L2xiWKMTf2JGPtNc1danw9hyoTTbDWkDs4broHRhT6aDP3YxPTdgZMhJKxl&show_text=true&width=300"
    )

    val iframeTemplate = "<html>\n" +
            "<head>\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "<style>body { display: flex; flex-direction: column; justify-content: flex-start; align-items: center; height: 100vh; margin: 0; background-color: transparent; }</style>\n" +
            "</head>\n" +
            "<iframe src=\"{POST_URL}\" " +
            "width=\"310\" height=\"734\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowfullscreen=\"true\" allow=\"autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share\"></iframe>\n" +
            "</html>"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementsViewHolder {
        return AnnouncementsViewHolder(
            ItemAnnouncementsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return announcements.size
    }

    override fun onBindViewHolder(holder: AnnouncementsViewHolder, position: Int) {
        Log.d("AnnouncementsAdapter", "Post URL")
        val postUrl = announcements[position]
        Log.d("AnnouncementsAdapter", "Post URL: $postUrl")

        if (holder.binding.webView.url == null) { // Check if content is already loaded
            val htmlContent = iframeTemplate.replace("{POST_URL}", postUrl)
            holder.binding.webView.loadDataWithBaseURL(null, htmlContent, "text/html", "utf-8", null)
        }
    }
}

class AnnouncementsViewHolder(val binding : ItemAnnouncementsBinding) : RecyclerView.ViewHolder(binding.root){

}