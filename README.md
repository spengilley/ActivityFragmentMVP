ActivityFragmentMVP
===================

A demonstration of handling Activities and Fragments using <a href="http://square.github.io/dagger/">Dagger</a> dependency injection framework

The real benefit here is that you create an object graph only when you need it. This contributes to keeping the memory footprint of your app as low as possible.

The scoped object graph is created in the OnCreate() method of any Activity that extends BaseActivity. You just need to override the getModules() method in your concrete Activity implementations to load the module for that activity.
 
 Fragments, by way of the BaseFragment superclass method inject(), inject an instance of themselves into the Activities graph.


Featured on<br>
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ActivityFragmentMVP-brightgreen.svg?style=flat)](https://android-arsenal.com/details/3/1535)
