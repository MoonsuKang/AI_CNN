# TodoList
TodoList implemented with MVVM Architecture.(Using Kotlin &amp; Firebase)

### **\[Skills\]**

| **Languages** | **Kotlin** |
| --- | --- |
| **Architecture** | **MVVM** |
| **Jetpack** | **LiveData, DataBinding, ViewModel** |
| **Local DB** | **SharedPreferences** |
| **Image** | **Glide** |x
| **DI** | **Hilt** |
| **Cloud Platform** | **FireBase** |


### Implementation #1
1. Create a project.
2. Connect to Firebase.
3. Login, registration page UI.
4. Implementing login and registration functions.
5. Create a fragment pages.

### Configuring packages for MVVM architecture.
![image](https://github.com/kms9978/TodoList/assets/85223787/86c7c310-fa4c-4626-bdaa-1ad37a33f379)

| **Data** |  |
| --- | --- |
| **api** | Contains an API interface for communication with external services. For example, you can include an interface responsible for communicating with Firebase. |
| **model** | Defines a data model class. For example, include the data structure of Todo entries. |
| **repository** | It is responsible for interacting with data sources. For example, it manages communication with the Firebase Realtime Database and handles CRUD operations for data. |
| **Ui** |  |
| **base** | Define a base class that contains the app's basic UI components or common logic. |
| **adapter** | Contains the adapter class used to display lists, such as RecyclerView or ListView. |
| **view** | Define screen elements, such as activities or fragments. Responsible for UI shown to users. |
| **viewmodel** | Contains ViewModel classes. Acts as a mediator between View (Activity or Fragment) and Model |
|   |  |
| **utils** | Contains utility classes or helper functions commonly used by applications. For example, you can implement features such as converting date formats and checking network status. |


it's best to write it in the order of model → api → repository → viewmodel → ui → utils.

Add LiveData, Coroutine GlobeScope, 



