public class RoomStance implements Comparable<RoomStance> {
  private int id;
  private int time;
  private boolean isStarting;
  private int peopleCountBefore;

  RoomStance(int id, int time, boolean isStarting) {
    this.id = id;
    this.time = time;
    this.isStarting = isStarting;
  }

  RoomStance() {
    id = -1;
    time = -1;
    isStarting = false;
  }

  int getId() {
    return id;
  }

  int getTime() {
    return time;
  }

  boolean getIsStarting() {
    return isStarting;
  }

  public String toString() {
    return "\nid - " + getId() + "; time - " + getTime() + "; is starting - " + getIsStarting()
            + "; people count - " + getPeopleCountBefore();
  }

  void makePeopleCounting(RoomStance stance) {
    if (stance.getId() < 0) {
      peopleCountBefore = 0;
    } else {
      if (stance.getIsStarting()) {
        peopleCountBefore = stance.getPeopleCountBefore() + 1;
      } else {
        peopleCountBefore = stance.getPeopleCountBefore() - 1;
      }
    }
  }

  int getPeopleCountBefore() {
    return peopleCountBefore;
  }

  public int compareTo(RoomStance stance){
    return Integer.compare(this.time, stance.time);
  }
}
