package org.gavaghan.geodesy;

public class EllipsoidTestHelper
{
   public static Ellipsoid createWGS84()
   {
      return Ellipsoid.WGS84;
   }

   public static Ellipsoid createSphere()
   {
      return Ellipsoid.Sphere;
   }

   public static Ellipsoid createGRS80()
   {
      return Ellipsoid.GRS80;
   }
}
