import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  private static Range[] ranges = {
          new Range(0, 8,10),
          new Range(1, 9, 11),
          new Range(2, 17,20),
          new Range(3, 10, 16)};

  static private void calcRanges() {
    for (int i = 0; i < ranges.length; i++) {
      Range range = ranges[i];
      System.out.println("Range n - " + range.getId() + ", range - "
              + range.getStartTime()+ " - " + range.getEndTime()
              + ", range size - " + range.rangeSize());
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello World!\n");
    RangeMatcher matcher = new RangeMatcher();
    calcRanges();
    matcher.makeStanceRanges(new ArrayList<>(Arrays.asList(ranges)));
    ArrayList<RoomStance> rangeTimes = matcher.getRangesTimes();
    System.out.println("\nRanges Times:\n" + rangeTimes);
    ArrayList<RoomStance> countedPeopleTimes = new ArrayList<>();
    for (int i = 0; i < rangeTimes.size(); i++) {
      RoomStance beforeStance;
      RoomStance stance = rangeTimes.get(i);
      if (i == 0) {
        beforeStance = new RoomStance();
      } else {
        beforeStance = rangeTimes.get(i - 1);
      }
      stance.makePeopleCounting(beforeStance);
      countedPeopleTimes.add(stance);
    }
    System.out.println("\nRanges Times after people recounting:\n" + countedPeopleTimes);
    ArrayList<Range> totalRanges = matcher.calculateRanges(countedPeopleTimes);
    System.out.println("\nTotal ranges:\n" + totalRanges);
  }
}
