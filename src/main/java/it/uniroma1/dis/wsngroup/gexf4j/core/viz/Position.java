package it.uniroma1.dis.wsngroup.gexf4j.core.viz;

/**
 * Interface for the Position.
 *
 */
public interface Position {

	/**
	 * Returns the value of the x-coordinate
	 * @return a float number indicating the value of the x-coordinate
	 */
	float getX();
	
	/**
	 * Sets the value for the x-coordinate
	 * @param x a float number indicating the value of the x-coordinate
	 * @return the current Position
	 */
	Position setX(float x);
	
	/**
	 * Returns the value of the y-coordinate
	 * @return a float number indicating the value of the y-coordinate
	 */
	float getY();
	
	/**
	 * Sets the value for the y-coordinate
	 * @param y a float number indicating the value of the y-coordinate
	 * @return the current Position
	 */
	Position setY(float y);
	
	/**
	 * Returns the value of the z-coordinate
	 * @return a float number indicating the value of the z-coordinate
	 */
	float getZ();
	
	/**
	 * Sets the value for the z-coordinate
	 * @param z a float number indicating the value of the z-coordinate
	 * @return the current Position
	 */
	Position setZ(float z);
}