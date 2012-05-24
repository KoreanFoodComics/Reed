Reed
====

Introduction
------------

Reed is a game engine written in Groovy, capable of loading and running a game written in 
Groovy from non-compiled .groovy scripts. This allows for easily modifiable games, and
helps to make life easier.

In the future, Reed will be able to load a game from configuration files created with a
WYSIWYG editor, allowing people with no programming experience to create games.

Technical Details
-----------------

Reed runs on top of [Slick](http://slick.cokeandcode.com/), a game library intended to
make [LWJGL](http://lwjgl.org/) easier to use (basically, it wraps OpenGL). This gives
you a lot of freedom. You could choose to write a game on three levels. Writing a game
with Reed's methods lets you write it at a high level, without dealing with OpenGL or
input handling (Reed will, in the very near future, wrap Slick's input classes with a
key-bindings system). Writing at the Slick level lets you avoid OpenGL, but still has you
handle input and game states. Writing at the LWJGL level is essentially just writing
OpenGL. It gives you all the OpenGL and AL functions, and leaves it up to you to write
your game. Of course, these options aren't exclusive. You could handle input yourself,
but use Reed's screen classes, so you can avoid messing with game states, components,
mouse handling or other things that get in the way when you're trying to write a game.