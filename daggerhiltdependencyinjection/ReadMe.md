## Using Room DB with Hilt Dependency Injection

#Steps summarized 

- First step is adding the `dependencies` those can be found in build.gradle file.
- Create `AppDatabase`, `Entities` and `Daos` using `Room` library
- Create `AppModule` object class for dependency injection
- Create your `Repository` class, injecting `appDao`
- Create your `ViewModel`, injecting `Repository` class.
- Create `Hilt` application class and add it into `manifest` file

For details see projects files
