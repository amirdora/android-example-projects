## Using Room DB with Hilt Dependency Injection

#Steps summarized 

- First step is adding the `dependencies` those can be found in build.gradle file.
- Create Appdatabase, Entities and Dao using Room library
- Create AppModule object class for dependency injection
- Create your repository, injecting appDao
- Create your ViewModel, injecting appRepository
- Create Hilt application class and add it into manifest

For details see projects
