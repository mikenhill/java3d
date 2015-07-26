package com.mikenhill.java3d;

import java.rmi.NotBoundException;

import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.ColorCube;

import javax.media.j3d.Alpha;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

public class Hello3d {

public Hello3d()

{

   SimpleUniverse universe = new SimpleUniverse();

   BranchGroup group = new BranchGroup();
   
   //Spin
   TransformGroup objSpin = new TransformGroup();
   objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
   group.addChild(objSpin);

   //
   objSpin.addChild(new ColorCube(0.4));

   //Alpha
   Alpha rotationAlpha = new Alpha (-1, 4000);
   RotationInterpolator rotator = new RotationInterpolator(rotationAlpha, objSpin);
   
   //Bounds
   BoundingSphere bounds = new BoundingSphere();
   rotator.setSchedulingBounds(bounds);
   objSpin.addChild(rotator);
   
   universe.getViewingPlatform().setNominalViewingTransform();

   universe.addBranchGraph(group);
   

}

public static void main( String[] args ) {

   new Hello3d();

}

} // end of class Hello3d
