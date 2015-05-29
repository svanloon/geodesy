# Geodesy

This is a copy of Mike Gavaghan's [Geodesy][0] library, used without
permission.  This was a clone of ndimiduk's github, but rearranged the directory
structure to use the maven build paths.

Also, I'm also updated to use gradle to build the project.

Gradle can also be used to create the projects for intellij

./gradlew idea

And also the project for eclipse

./gradlew eclipse


The jar can be build just by running gradlew in the root directory.

./gradlew clean test jar

You can create the javadoc by running

./gradlew javadoc

Note:
The GeodeticCalculatorAgitarTest class could use some love to update from Mockingbird to anything more common. 

This code was constructed to mimic [http://www.ngs.noaa.gov/PUBS_LIB/inverse.pdf](http://www.ngs.noaa.gov/PUBS_LIB/inverse.pdf)

Here's an example about how to calculate distance from [http://www.gavaghan.org/blog/2007/11/16/java-gps-receivers-and-geocaching-vincentys-formula/](http://www.gavaghan.org/blog/2007/11/16/java-gps-receivers-and-geocaching-vincentys-formula/)
```
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;

public class Example
{
    static public void main(String[] args)
    {
        // instantiate the calculator
        GeodeticCalculator geoCalc = new GeodeticCalculator();
        // select a reference elllipsoid
        Ellipsoid reference = Ellipsoid.WGS84;
        // set Lincoln Memorial coordinates
        GlobalCoordinates lincolnMemorial;
        lincolnMemorial = new GlobalCoordinates(38.88922, -77.04978);
        // set Eiffel Tower coordinates
        GlobalCoordinates eiffelTower;
        eiffelTower = new GlobalCoordinates(48.85889, 2.29583);
        // calculate the geodetic curve
        GeodeticCurve geoCurve = geoCalc.calculateGeodeticCurve(reference, lincolnMemorial, eiffelTower);
        double ellipseKilometers = geoCurve.getEllipsoidalDistance() / 1000.0;
        double ellipseMiles = ellipseKilometers * 0.621371192;
        System.out.println("Lincoln Memorial to Eiffel Tower using WGS84");
        System.out.printf(" Ellipsoidal Distance: %1.2f kilometers (%1.2f miles)\n", ellipseKilometers, ellipseMiles);
        System.out.printf(" Azimuth: %1.2f degrees\n", geoCurve.getAzimuth());
        System.out.printf(" Reverse Azimuth: %1.2f degrees\n",
        geoCurve.getReverseAzimuth()
        );
    }
}
```

[0]: http://www.gavaghan.org/blog/free-source-code/geodesy-library-vincentys-formula-java/

