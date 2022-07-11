package com.example.bikelinklist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bikelinklist.models.Place
import com.example.bikelinklist.models.UserMap
import kotlinx.android.synthetic.main.activity_main.*
const val EXTRA_USER_MAP = "EXTRA_USER_MAP"
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userMaps = generateSampleData()
        //Set layout manager
        rvMaps.layoutManager = LinearLayoutManager(this)

        //Set adapter
        rvMaps.adapter = MapsAdapter(this, userMaps, object : MapsAdapter.OnClickListener {
            override fun onItemClick(position: Int) {
                Log.i(TAG, "onItemClick $position")
                //open new activity
                val intent  = Intent(this@MainActivity, DisplayMapActivity::class.java)
                intent.putExtra(EXTRA_USER_MAP, userMaps[position])
                startActivity(intent)
            }
        })
    }
    private fun generateSampleData(): List<UserMap> {
        return listOf(
            UserMap(
                "Demo 1 - Chỉ Dẫn",
                listOf(
                    Place("Ngã Ba Chương Dương", "Đi Xe Bus 08 đến trạm", 10.850607694452101, 106.7601188017283),
                    Place("Cao Đẳng Xây Dựng 2", "Di chuyển đến trạm 2, bắt Bus 89", 10.849544770762828, 106.77193795575532)
                )
            ),
            UserMap("Demo 2 - Tìm xe",
                listOf(
                    Place("Ngã Ba Chương Dương", "Available:21", 10.850607694452101, 106.7601188017283),
                    Place("Cao Đẳng Xây Dựng 2", "Available:32", 10.849544770762828, 106.77193795575532),
                    Place("Đại Học Ngân Hàng", "Available:15", 10.857790102825668, 106.76343617334743),
                    Place("Đại Học Ngân Hàng-chiều đi", "Available:28", 10.85826820818655, 106.76321489110505),
                    Place("TRƯỜNG ĐH SPKT", "Available:60", 10.849562458076065, 106.77190687528083),
                    Place("TRƯỜNG ĐH SPKT-CHIỀU ĐI", "Available:60",10.849973402970408, 106.77192028632759),
                    Place("Chùa Hòa Quang", "Available:35", 10.857817124461318, 106.77715962725419),
                    Place("Công ty Dệt Việt Thắng", "Available:32", 10.858032311273625, 106.77739840717898),
                    Place("ĐH Kinh tế-luật","Available:42", 10.869246279223804, 106.77795488925317),
                    Place("ĐH Nông Lâm", "Available:60",10.86736824524995, 106.78848123932073),
                    Place("KTX Khu B", "Available:50",10.881657299684099, 106.78233483217917),
                    Place("ĐH Khoa học tự nhiên", "Available:70",10.875695165764593, 106.79846061662445),
                    Place("Nhà Văn Hóa Thanh Niên", "Availale:65",10.875170606901087, 106.80110713039117),
                    Place("Thư Viện Trung Tâm", "Available:38",10.870580880312998, 106.79608152179308)
                )
            ),

        )
    }
}