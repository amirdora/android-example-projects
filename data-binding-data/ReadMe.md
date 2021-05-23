## Data Binding Views and Data:
- Data binding views and data minimizes the code for app logic and layouts. It eliminates the need for these method calls `findViewById` and `setText.`

### To enable Data Binding:
1.  Open app's `build.gradle` file and enable data binding

<pre>
android {

dataBinding.enabled = true

}
</pre>
2. Wrap your XML layouts that use data-binding with root tag, the model that we bind to the view in this case is `User`

<pre>
&lt;layout&gt;

  &lt;data&gt;
        <!-- Declare a variable by specifying a name and a data type. -->
        <!-- Use fully qualified name for the type. -->
        &lt;variable
            name="User"
            type="com.example.databindingdata.modelData.User" /&gt;
    &lt;/data&gt;

    ... your views go here ...

&lt;/layout&gt;


</pre>

3. To bind `name` property of `User` model to `textView`, we use annotation of `@{}` syntax. 

        <TextView
            android:text="@={User.name}"/>
            

5. Next we need to create variable for binding object inside our activity or fragment, and inside oncreate replace setContentView. 


<pre>	
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.user = userData // binds the model

        binding.showTextButton.setOnClickListener {

            // update layout by updating model
            binding.apply {
                userData.name = "Amir"
                invalidateAll()
            }

        }
    }
</pre>	
