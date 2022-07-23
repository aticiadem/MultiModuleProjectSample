# MultiModuleProjectSample
You can learn how to create multi module Android project with this repository. You can read this article in Turkish. Go to this [link][0]. 

Greetings, with this article, we will learn about the benefits of a multi-module project and how we can create a multi-module project.
<br>
Before I start, I need to mention the following: As you know, many methods can be used when performing such operations. 
As I progress, I will use one of these methods and we will proceed with the Kotlin programming language in the Android Studio environment. 
Let's get started :)
<br>
<br>

![start-image][1]
<h5 align="center">Image 1 Photo by Ryoji Iwata[1]</h3>
<br>

## Benefits of the Modular Project

One of the main controversial topics of Android development is Modularization. In the past, it was not strange at all that our project only had one application module. We need to concentrate on the layers of our application, separate them and follow some principles of some famous architectures. But these days, when we have a large team working on a monolithic project that is facing a lot of issues like compile time, code conflicts, and running our app per change, maintaining projects gets out of hand. We may be disappointed while developing and executing our project.
<br>
<br>
There are many reasons to Modularize the Project:

- Build Time: The long Compile and Build times of our project.
- Reusability: Our sharing of some Features between multiple applications.
- Maintenance: Huge, spaghetti codebase where each Feature has many side effects on the other.
- Test: You can’t write a simple test scenario for a self-contained Feature.
- App Size: Contrary to a monolithic application size, in a modular application, we can achieve smaller size installation files thanks to Bundle and Dynamic Features.
- Demo Apps: Reasons like running the whole project for a small change and running a single Feature isolated from the whole application lead us to modular builds.
<br>


![start-image][2]
<h5 align="center">Image 2 Photo by Ryan Quintal[2]</h3>

<br>

## Creating the Project

In the project we will create, there will be app, buildSrc, data and domain modules. To briefly mention them;

- app: Application module. It contains all the initialization logic for the Android environment.
- buildSrc: In this module, we keep the whole version system to be used in the application.
- domain: It is the module that contains the most important part of the application, the business logic. This module depends solely on itself and all the interactions it does are through dependency reversal.
- data: It is the module that contains the data (local, remote, etc.) in the application.

After this brief briefing, let's first create a normal project. The monolithic (single-module) Android project looks like this.
<br>
<br>

![image][3]
<h5 align="center">Default Project View</h3>

<br>
Now let's look at how a module can be added. Let's take the first step by adding a Kotlin module called buildSrc to manage libraries more easily :)

For this, we can click on File -> New -> New Module. These clicks take us to a screen like the one below.
<br>
<br>

![image][4]
<h5 align="center">Create the buildSrc module</h3>

<br>
Our buildSrc module will not be an Android related process, for this we can build the module via Java or Kotlin library.
<br>
<br>
Note: If you get an error like "'buildSrc' cannot be used as a project name as it is a reserved name", go to settings.gradle and delete the "include ':buildSrc'" code here and try to build again.
<br>
<br>
After adding the buildSrc module, you can activate the Kotlin DSL by renaming the build.gradle file of the relevant module to build.gradle.kts. Also you can make the content as follows.
<br>
<br>

![image][5]
<h5 align="center">build.gradle.kts</h3>

<br>
After doing all this, we will finally create a Versions Kotlin file for buildSrc where we can keep the relevant versions. 
Here we will hold values to define the versions we will use within the application. So, we will be able to easily do version control from one place. 
You can see the latest version of the "buildSrc" module and the Versions Kotlin file in the image below.
<br>
<br>
<br>

![image][6]
<h5 align="center">buildSrc module and Versions Kotlin file</h3>

<br>
Now let's add the "data" module. As when adding the "buildSrc" module, we will proceed as File -> New -> New Module and add the module as follows.
<br>
<br>

![image][7]
<h5 align="center">Create the data module</h3>

<br>
You can see the latest version of the "data" module below. You can fill the contents of the package as you wish.
<br>
<br>

![image][8]
<h5 align="center">Latest version of data module</h3>

<br>
Now that we have created the data module, let's create the domain module. Again, let's go to File -> New -> New Module.
<br>
<br>

![image][9]
<h5 align="center">Create the domain module</h3>

<br>
This way we can create the "domain" module. The reason why we move to Android here is shaped according to our needs. For example, 
if we needed a manifest file in this module, we could create our module via the Android Library option.
<br>
<br>

![image][10]
<h5 align="center">Adding the domain module to the project</h3>
<br>

This is how we added the "domain" module to the project.

Above, we had a discourse about the speed of module projects. There are some actions we can take when accelerating a modular project.
It is possible to get a build much faster by adding the following codes to our "gradle.properties" file.
<br>
<br>

```
org.gradle.jvmargs=-Xmx2048m -XX:+UseParallelGC
org.gradle.daemon=true
org.gradle.caching=true
org.gradle.parallel=true
```

<br>

For more detailed information about these codes, you can take a look at my article titled ["Android Projelerde Build Sürelerini Hızlandırma"][11].

### Abstract
In this article, we talked about the importance of modularity in our Android applications and how we can create a modular project. You can manage your project better by creating different modules according to your needs.

## References:

1. https://unsplash.com/@ryoji__iwata?utm_source=medium&utm_medium=referral
2. https://unsplash.com/@ryanquintal?utm_source=medium&utm_medium=referral
3. https://www.droidcon.com/2022/02/15/android-modularization-preps-things-to-know-before-modularizing-your-app/

## License

MIT License

Copyright (c) 2022 Adem ATİCİ

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


[0]: https://medium.com/p/2c4135fbd03e/edit
[1]: https://cdn-images-1.medium.com/max/1600/0*8k0Dx_781BVpti7K
[2]: https://cdn-images-1.medium.com/max/1600/0*rS7EQWn0qqhDG8D8
[3]: https://user-images.githubusercontent.com/58858983/180596026-28b05be8-864a-4992-a068-b3a72f6a388c.png
[4]: https://user-images.githubusercontent.com/58858983/180596132-2555a255-3bbc-4f08-917f-02be6712730e.png
[5]: https://user-images.githubusercontent.com/58858983/180596268-13155627-c447-48f5-ad8e-746d4efc136a.png
[6]: https://user-images.githubusercontent.com/58858983/180596429-133c268d-0f11-451a-8710-01f7c2da331e.png
[7]: https://user-images.githubusercontent.com/58858983/180596596-f9646302-ceab-40b5-8342-e0655b5ac7c3.png
[8]: https://user-images.githubusercontent.com/58858983/180596659-3d4c66b9-ca37-499c-8bc3-675a320b3dfe.png
[9]: https://user-images.githubusercontent.com/58858983/180596714-d83bfe48-52fa-425c-a51a-eafe19d91141.png
[10]: https://user-images.githubusercontent.com/58858983/180596807-77460703-6c0b-4965-b4a8-eea438f54a00.png
[11]: https://medium.com/p/abba308019d2/edit
