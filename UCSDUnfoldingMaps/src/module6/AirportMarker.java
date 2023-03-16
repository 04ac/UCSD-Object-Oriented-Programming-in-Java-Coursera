package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(11);
		pg.ellipse(x, y, 5, 5);
		
		
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		// show rectangle with Name and Airport Code
		String city = this.getStringProperty("city").substring(1, this.getStringProperty("city").length() - 1) + ", " + this.getStringProperty("country").substring(1, this.getStringProperty("country").length() - 1);
		String name = "Airport Name: " + this.getStringProperty("name").substring(1, this.getStringProperty("name").length() - 1);
		String code = "Airport Code: " + this.getStringProperty("code").substring(1, this.getStringProperty("code").length() - 1);
		pg.pushStyle();

		pg.rectMode(PConstants.CORNER);

		pg.stroke(110);
		pg.fill(255,255,255);
		//Make rect with maximum width to accommodate all fields
		pg.rect(x, y + 15, Math.max(pg.textWidth(name), Math.max(pg.textWidth(city), pg.textWidth(code))) + 6, 18*3 + 3, 5);

		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.fill(0);
		pg.text(city, x + 3 , y +18);
		pg.text(name, x + 3 , y +18*2);
		pg.text(code, x + 3 , y +18*3);


		pg.popStyle();
	}
	
}
