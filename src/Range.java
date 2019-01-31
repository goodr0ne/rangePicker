class Range {
  private int id;
  private int startTime;
  private int endTime;

  Range(int id, int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.id = id;
  }

  int rangeSize() {
    return (endTime - startTime);
  }

  int getId() {
    return id;
  }

  int getEndTime() {
    return endTime;
  }

  int getStartTime() {
    return startTime;
  }

  public String toString() {
    return "\nPeople count - " + id + "; time length - " + (getEndTime() - getStartTime()
            + "; started/ended - " + getStartTime() + "-" + getEndTime()) ;
  }
}
