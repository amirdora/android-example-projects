## Data Binding:
- Data binding eliminates the need to run `findViewById()` at run time which improves app performance.

### To enable Data Binding:
1.  Open app's `build.gradle` file and enable data binding

<pre>
android {

dataBinding.enabled = true

}
</pre>
2. Wrap your XML layouts that use data-binding with root tag

<pre>
&lt;layout&gt;

... your views go here ...

&lt;/layout&gt;


</pre>
3. Next we need to create variable for binding object inside our activity or fragment, and inside `oncreate` replace `setContentView`. 
<pre>	
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
</pre>	

