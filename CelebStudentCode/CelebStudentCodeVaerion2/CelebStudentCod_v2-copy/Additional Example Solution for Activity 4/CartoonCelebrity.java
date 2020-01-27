/**
 * 
 * @author Sage Miller
 * 22/04/2019
 */
public class CartoonCelebrity extends Celebrity {
  private String show; //tv show or movie in which cartoon celebrity appears
  
  /**
   * Constructs a CartoonCelebrity
   * @param answer - the cartoon character's name
   * @param clue - a clue about the cartoon character other than the show/movie it appears in
   * @param show - the show/movie which the cartoon character appears 
   */
  public CartoonCelebrity(String answer, String clue)
  {
    super(answer, clue.substring(clue.indexOf(",")+1));
    this.show = clue.substring(0,clue.indexOf(","));
  }
  
  /**
   * randomly returns either the clue (80% of the time) or the show (20% of the time)
   */
  @Override
  public String getClue() 
  {
    if(Math.random()<0.2)
      return "Appeared in " + show;
    return super.getClue();
  }
  
  /**
   * adds info about probability
   */
  @Override
  public String toString() 
  {
    return super.toString() + ", and the character appeared in " + show;
  }
  
  /**
   * Mutator for updating the show
   * @param show - the replacement show that the cartoon character appears in
   */
  public void setShow(String show) 
  {
    this.show = show;
  }
  
  /**
   * Returns the show in which the cartoon character appeared
   * @return show
   */
  public String getShow() 
  {
    return show;
  }
}
