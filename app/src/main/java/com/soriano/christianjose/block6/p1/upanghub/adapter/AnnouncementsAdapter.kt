package com.soriano.christianjose.block6.p1.upanghub.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.soriano.christianjose.block6.p1.upanghub.databinding.ItemAnnouncementsBinding
import com.soriano.christianjose.block6.p1.upanghub.dataclass.AnnouncementLinks

class AnnouncementsAdapter() : RecyclerView.Adapter<AnnouncementsViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<AnnouncementLinks>(){
        override fun areItemsTheSame(oldItem: AnnouncementLinks, newItem: AnnouncementLinks): Boolean {
            return oldItem.link == newItem.link
        }

        override fun areContentsTheSame(oldItem: AnnouncementLinks, newItem: AnnouncementLinks): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var announcements: List<AnnouncementLinks>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

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
            val htmlContent = iframeTemplate.replace("{POST_URL}", postUrl.link)
            holder.binding.webView.loadDataWithBaseURL(null, htmlContent, "text/html", "utf-8", null)
        }
    }
}

class AnnouncementsViewHolder(val binding : ItemAnnouncementsBinding) : RecyclerView.ViewHolder(binding.root){

}