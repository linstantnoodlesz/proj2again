public class Planet{ 
	double yyPos, xxPos, xxVel, yyVel, mass;
	String imgFileName;
	double g = 6.67e-11;

/** Planet Constructor. xxPos is the x-position of a planet; yyPos the y-position;
xxVel the x-velocity; yyVel the y-velocity; masss the mass; and imgFileName as the name of the image file
of the planet as a string. **/

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
/** makes copy of Planet p **/

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
/** Calculates distance between 2 planets; takes in 1 planet calculates distance of another planet to itself. 
**/
	public double calcDistance(Planet p) {
		return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos) + (yyPos-p.yyPos)*(yyPos-p.yyPos));
	}
/** Takes in a planet and describes the force exerted on this planet by the given planet **/
	public double calcForceExertedBy(Planet p) {
		double dist = calcDistance(p);
		return g * mass * p.mass / (dist * dist);
	}
/**Takes in a planet and describes the force exerted on this planet by the given planet in the x-direction **/
	public double calcForceExertedByX(Planet p) {
		return calcForceExertedBy(p) * (p.xxPos-xxPos) / calcDistance(p);
	}
/**Takes in a planet and describes the force exerted on this planet by the given planet in the y-direction **/
	public double calcForceExertedByY(Planet p){ 
		return calcForceExertedBy(p) * (p.yyPos-yyPos) / calcDistance(p);
	}
/** Takes in an array of planets and calculates the Net X force exerted by all planets in that array upon the current Planet **/
	public double calcNetForceExertedByX(Planet[] planets) {
		double NetForcex = 0;
		for (int i = 0; i < planets.length; i++) {
			if (!this.equals(planets[i])) {
				NetForcex += calcForceExertedByX(planets[i]); 
			}
		}return NetForcex;
	}
/** Takes in an array of planets and calculates the Net Y force exerted by all planets in that array upon the current Planet **/
	public double calcNetForceExertedByY(Planet[] planets) {
		double NetForcey = 0;
		for (int i = 0; i < planets.length; i++) {
			if (!this.equals(planets[i])) {
				NetForcey += calcForceExertedByY(planets[i]);
			}
		}return NetForcey;
	}
/** updates a Planet's position and velocity with change in time and given forces in X and Y-direction **/
	public void update(double dt, double fX, double fY) { 
		double accelerationx = fX / mass;
		double accelerationy = fY / mass;
		xxVel = xxVel + (dt * accelerationx);
		yyVel = yyVel + (dt * accelerationy);
		xxPos = xxPos + (dt*xxVel);
		yyPos = yyPos + (dt*yyVel);

	}
	public void draw() {
		StdDraw.picture(xxPos, yyPos, imgFileName);
	}
}






