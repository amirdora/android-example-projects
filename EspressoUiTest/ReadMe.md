## Espresso Ui Test Example
- This app demonstrates a simple example of espresso Ui test. It's a simple test in which user input is matched with text in `textView`. Code snippet can be seen below.

### To enable Data Binding:
1. `MainActivityTest` test class can be found inside `EspressoUiTest` module `androidTest` directory .

<pre>
    @Test
    public void testUserInputScenario() throws InterruptedException {
        // input some text in the edit text
        Espresso.onView(withId(R.id.etTextToChange)).perform(typeText(mName));
        // close soft keyboard
        Espresso.closeSoftKeyboard();
        // perform button click
        Espresso.onView(withId(R.id.btnChange)).perform(click());
        // checking the text in the text view
        Espresso.onView(withId(R.id.tvChangedText)).check(matches(withText(mName)));
        Thread.sleep(5000);
    }
</pre>
