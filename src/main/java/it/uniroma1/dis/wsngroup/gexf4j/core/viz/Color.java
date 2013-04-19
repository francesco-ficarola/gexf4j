package it.uniroma1.dis.wsngroup.gexf4j.core.viz;

/**
 * Interface for the Color.
 *
 */
public interface Color {

	/**
	 * Returns the value of the red color
	 * @return an int number indicating the value of the red color
	 */
	int getR();
	
	/**
	 * Sets the value for the red color
	 * @param r an int number indicating the value of the red color
	 * @return the current Color
	 */
	Color setR(int r);
	
	/**
	 * Returns the value of the green color
	 * @return an int number indicating the value of the green color
	 */
	int getG();
	
	/**
	 * Sets the value for the green color
	 * @param g an int number indicating the value of the green color
	 * @return the current Color
	 */
	Color setG(int g);
	
	/**
	 * Returns the value of the blue color
	 * @return an int number indicating the value of the blue color
	 */
	int getB();
	
	/**
	 * Sets the value for the blue color
	 * @param b an int number indicating the value of the blue color
	 * @return the current Color
	 */
	Color setB(int b);
}