package com.soriano.christianjose.block6.p1.upanghub

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.soriano.christianjose.block6.p1.upanghub.adapter.AnnouncementsAdapter
import com.soriano.christianjose.block6.p1.upanghub.databinding.FragmentHomeBinding
import com.soriano.christianjose.block6.p1.upanghub.dataclass.AnnouncementLinks
import com.soriano.christianjose.block6.p1.upanghub.viewmodel.SharedViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private lateinit var announcementLinkList :List<AnnouncementLinks>
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private var filterMode = "three"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedViewModel.updateAppBarTitle("Home")
        announcementLinkList = listOf(

            //CSDL
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid02H8vn85545AA7QWigpCUcs5NDqW67Yrg7PWAiM3X5Vc33XuJG4i1Py5ge6cdGyaWSl&show_text=true&width=300", "csdl"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid0kcXJurhg7Z1TSWBFDcfmv45NAM2CC4yWPbQbd6X22yZeLE5L1KmerRsYTfz8Sg5nl&show_text=true&width=300", "csdl"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid02Q7SdTzFNbHZF13m14CGaXJmPxDF2ho7QdyadxL11u2Fuz2153hf237TXaiDc7nHml&show_text=true&width=300", "csdl"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinmaupang%2Fposts%2Fpfbid024BEbiLsPwisfyxbiTjDhGxQyasMApRxogq6ArxugyGTaEbX8boRzFgsBHwy88SoKl&show_text=true&width=300", "upang"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinmaupang%2Fposts%2Fpfbid0n6aeZZS5fc1axAZH1Ub1dPC9u3WQhogaN94hMyoztPRJhvTZHcANZRpH9xiBok7Tl&show_text=true&width=300", "upang"),
            AnnouncementLinks("https://www.facebook.com/plugins/video.php?height=476&href=https%3A%2F%2Fwww.facebook.com%2Fphinmaupang%2Fvideos%2F791116442884803%2F&show_text=false&width=267&t=0", "upang"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid02eNbjPkyJDrg7YuPLXDoSW9k68hPaYmCt7rBWVc1cEJJ1MicJgAEi8mRYFoXY3BVYl&show_text=true&width=300", "csdl"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid0JmPuibpGYPBi3BpzUfsi1aCwQz8Kp4pUPWBugAQwHNgoR33d5Ubwpt2p3YjkfRPml&show_text=true&width=300", "csdl"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid02US5b17N9Cf9AA2hkjzjGV7Aogbo6BoUCTZLkZqb8t6ABsqrrydKsQ2QDV3Do1eE1l&show_text=true&width=300", "csdl"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid025VFC9QAY699aZoqSCTdesg5fk6emm6DwndzgN6nHp7WSY1qfspP69x42g5nWwZ1il&show_text=true&width=300", "csdl"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinmaupang%2Fposts%2Fpfbid02z9CNtoaD1tHP3nUDXzDCbrzihiq66gHzDbWrxq1c2g5p26qfbKC6aW654hgYT1zCl&show_text=true&width=300", "upang"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinmaupang%2Fposts%2Fpfbid02JBkvLxTXB7uQ6jUG5f98dob8zAFDSLmVs9RQ3F24PR7Noo5H1TrdkDTGstveLRSel&show_text=true&width=300", "upang"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid0bd9sy5xWEcqsxPX52yvRRTemidk639TccMo4bFWdPxn4JAiBmjMXpjkLbWgQTKZ8l&show_text=true&width=300", "csdl"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinmaupang%2Fposts%2Fpfbid02dVAMXY8YoNZ2US5p9nKWWWHDLbx2xRxWfXMg3qgwGU2yeR2qEvUj9skd2wEDCGTgl&show_text=true&width=300", "upang"),
            AnnouncementLinks("https://www.facebook.com/plugins/video.php?height=214&href=https%3A%2F%2Fwww.facebook.com%2Fphinmaupang%2Fvideos%2F935867017842314%2F&show_text=false&width=300&t=0", "upang"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid0257x2VszV4Gqu5gqpgMZNkCNHsUT6rWhNyKnXY7M8ixWHxPhpfwL9qpmRf4ykAMwcl&show_text=true&width=300", "csdl"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinmaupang%2Fposts%2F383689084596359%3A383689084596359&show_text=true&width=300", "upang"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinmaupang%2Fposts%2Fpfbid0LUziGfmq4EQe9SdMxLNmCxv8UocHvaoXXTjuHU3uUHVSLPYmmA2aBkZd59KP2Tdxl&show_text=true&width=300", "upang"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinmaupang%2Fposts%2Fpfbid02SEdbGbb9nu5ExccwPv16NfeNASmG95ufjyQ9aihiNbfZGDbCb4uGwX5yoeSGWyVfl&show_text=true&width=300", "upang"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fup.csdl%2Fposts%2Fpfbid0tzHmdKmDVwvYXmpvaAkd5tWvt19rdBKikRb9Hzze6KfWcX3278hTCTGgC49YEsCTl&show_text=true&width=300", "csdl"),
            //UPang
            //tuesday
            //sunday
            //Cite
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinma.up.citesc%2Fposts%2Fpfbid032nxutAEtAG1wBN5LgMcqDFJBN7bJPTag4TXvLPpkKTjGeFnsQdTRhDFoDfkfktvWl&show_text=true&width=300", "cite"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinma.up.citesc%2Fposts%2Fpfbid02MTM4tngGpizYy5ZL3HkuWpw5CGrjcgBug7zxRzteZQ1JyfprfLJqsx14pGFo2hujl&show_text=true&width=300", "cite"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinma.up.citesc%2Fposts%2Fpfbid02jga8uHKkE6xCwDMDToiyQvcrcTU5WQbd2tApebNd2iAVVo2zR3pK13bxy9qtMA8el&show_text=true&width=300", "cite"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinma.up.citesc%2Fposts%2Fpfbid02Kuo4RqSBQ9yweYi8WTPwsTqPfM2xSnLjWv8T1ANFEWn8Km7FaoEA6XzEaX3FdSfTl&show_text=true&width=300", "cite"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinma.up.citesc%2Fposts%2Fpfbid02mETCPK7N7WFkFNGPvVgxTVxhnNz3HCdYj8wsVpqhVgpXZuR1y42nWb4wbEkShCB4l&show_text=true&width=300", "cite"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinma.up.citesc%2Fposts%2Fpfbid0TLdV4amFFQvnD4tCLN9AYeZ7vPRMHbHrJZtgnzJLiEbsBXkhmjWaFZ2fQUYXnT1Tl&show_text=true&width=300", "cite"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinma.up.citesc%2Fposts%2Fpfbid02dhW7nSR5i433HbHo2oBoBYi7oNmLfF8nSY1ZEAXqLzFAuZ2cW8CrPcGtE1AffG1jl&show_text=true&width=300", "cite"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinma.up.citesc%2Fposts%2Fpfbid0gJDMXLrEHdHpX7EyTaAPgomUmcLqwLJxrzqicKRVskLerwy8Tbta5UfnwHdgsLFdl&show_text=true&width=300", "cite"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinma.up.citesc%2Fposts%2Fpfbid0QbqZ2fjqZUgooMPATR3yhfjbCfbZykJ5yZ7vfL1eUWsX5BXLKnXkRVeQfZEfiN3el&show_text=true&width=300", "cite"),
            AnnouncementLinks("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fphinma.up.citesc%2Fposts%2Fpfbid02dv4YokDAU6eR5sXcyKqFgUegmszrVrTafwTbbnZgPRYNep1kpytM5VGGTf9gtZd5l&show_text=true&width=300", "cite"),


            )
        val recyclerViewAdapter = AnnouncementsAdapter()
        binding.rvAnnouncements.adapter = recyclerViewAdapter
        recyclerViewAdapter.announcements = announcementLinkList
        binding.toggleButton.check(R.id.button2)
        binding.toggleButton.check(R.id.button3)
        binding.toggleButton.addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->
            Log.d("MyTag", "checkedButtonId: ${toggleButton.checkedButtonIds}")
            Log.d("MyTag", "checkedId: $checkedId")

            val filterMap = mapOf(
                2131231260 to "csdl",
                2131231261 to "upang",
                2131231262 to "cite"
            )

            val activeFilters = binding.toggleButton.checkedButtonIds
                .mapNotNull { filterMap[it] } // Map IDs to filter terms

            val filteredCounts = announcementLinkList.filter { it.page in activeFilters }

            Log.d("MyTag", "activeFilters: $activeFilters")
            Log.d("MyTag", "filteredCounts: $filteredCounts")
            recyclerViewAdapter.announcements = filteredCounts


        }

        binding.cvMap.setOnClickListener {
            findNavController().navigate(R.id.action_map)
        }



        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}