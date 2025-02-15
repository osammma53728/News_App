package ai.codia.x.kotlin.demo

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : BaseMainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated() {
        
    }

    private fun dp2px(dpValue: Double): Int {
        val scale = this.resources.displayMetrics.density
        return (dpValue * scale).toInt()
    }
}
