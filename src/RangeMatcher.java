import java.util.ArrayList;
import java.util.Collections;

class RangeMatcher {
  private int[][] roomStances;
  private ArrayList<RoomStance> rangesTimes = new ArrayList<>();

  void makeStanceRanges(ArrayList<Range> ranges) {
    for (int i = 0; i < ranges.size(); i++) {
      Range range = ranges.get(i);
      rangesTimes.add(new RoomStance(i, range.getStartTime(), true));
      rangesTimes.add(new RoomStance(i, range.getEndTime(), false));
    }
    Collections.sort(rangesTimes);
  }

  ArrayList<RoomStance> getRangesTimes() {
    return rangesTimes;
  }

  ArrayList<Range> calculateRanges(ArrayList<RoomStance> stances) {
    ArrayList<Range> ranges = new ArrayList<>();
    int maxPeople = 0;
    for (int i = 0; i < stances.size(); i++) {
      int count = stances.get(i).getPeopleCountBefore();
      if (count > maxPeople) {
        maxPeople = count;
      }
    }
    for (int i = 0; i < stances.size(); i++) {
      RoomStance stance = stances.get(i);
      if (stance.getPeopleCountBefore() == maxPeople) {
        Range maxRange = new Range(maxPeople, stances.get(i - 1).getTime(), stance.getTime());
        ranges.add(maxRange);
      }
    }
    return ranges;
  }
}
