# Geodesy

This is a copy of Mike Gavaghan's [Geodesy][0] library, used without
permission.  This is a fork of ndimiduk's github.

# Changes from ndimiduk
* Added gradle to allow for stand alone builds
* Removed eclipse specific files (.classpath and .project)
* Gradle is also configured to generate Eclipse and IntelliJ IDEA project files 
* Removed javadoc because it can be generated
* Updated junit from 3 to 4
* Migrated agritr directory to normal test directory, but didn't fix Mockingbird dependencies (especially in GeodeticCalculatorAgitarTest).


Generate IntelliJ project files
```
./gradlew idea
```
Generate Eclipse project files
```
./gradlew eclipse
```

Build and test the jar
```
cd <checked out directory>
./gradlew clean test jar
```

Generate javadoc in the build directory
```
./gradlew javadoc
``` 

This code was constructed per the documentation to comply with: [http://www.ngs.noaa.gov/PUBS_LIB/inverse.pdf](http://www.ngs.noaa.gov/PUBS_LIB/inverse.pdf)

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
        System.out.printf(" Reverse Azimuth: %1.2f degrees\n",geoCurve.getReverseAzimuth());
    }
}
```

[0]: http://www.gavaghan.org/blog/free-source-code/geodesy-library-vincentys-formula-java/

