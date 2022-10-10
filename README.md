# MoveInSync TimerProject

## Dependancy reuired in  app build.gradle
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0-rc01'

## Activity Code
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(CountDownViewModel::class.java)
        bt_start_timer.setOnClickListener { viewModel.starTimer() }
        bt_stop_timer.setOnClickListener { viewModel.stopTimer() }

        viewModel.countValue.observe(this, Observer {
            tv_timer_time.text = it.toString()
        })


    }
}

## CountDownViewModel which have start and stop timer code

class CountDownViewModel : ViewModel() {
    private var _countValue = MutableLiveData<Int>(0)
    val countValue: LiveData<Int>
        get() = _countValue
    private lateinit var job: Job


    fun starTimer() {
        job = viewModelScope.launch {
            while (true) {
                delay(1000)
                _countValue.value = _countValue.value?.plus(1)
            }
        }

        job.start()
    }

    fun stopTimer() {
        job.cancel()
    }

}

## APP Snapshots:
<img src="app/img/1.png" width="300" height="600">     <img src="app/doc/2.png" width="300" height="600">   <img src="app/doc/3.png" width="300" height="600">

