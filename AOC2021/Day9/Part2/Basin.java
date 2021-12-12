package AOC2021.Day9.Part2;

import java.util.ArrayList;
import java.util.HashMap;

public class Basin {
  HashMap<String, Point> points = new HashMap<String, Point>();
  HashMap<String, Boolean> checkedPoints = new HashMap<String, Boolean>();

  public Basin (Point lowPoint) {
    points.put(lowPoint.getIndex(),lowPoint);
    checkedPoints.put(lowPoint.getIndex(), false);
  }

  public void addPoint(Point point) {
    points.put(point.getIndex(),point);
    checkedPoints.put(point.getIndex(),false);
  }

  public void checkNeighbours(HashMap<String, Point> fullMap) {
    for(Point point : points.values()) {
      if(!checkedPoints.get(point.getIndex())) {
        ArrayList<String> neighbours = point.getNeighbours();
        for(String neighbour : neighbours) {
          Point checkedNeighbour = fullMap.get(neighbour);
          if(checkedNeighbour.getValue() !=9) {
            if(!checkedPoints.containsKey(checkedNeighbour.getIndex())) {
              checkedPoints.put(checkedNeighbour.getIndex(), false);
            }
          }
        checkedPoints.replace(point.getIndex(), true);
        }
      }
    }

    for(String index : checkedPoints.keySet()) {
      if(!points.containsKey(index)) {
        points.put(index, fullMap.get(index));
      }
    }
  }

  public void calcSize(HashMap<String, Point> fullMap) {
    while(checkedPoints.containsValue(false)) {
      checkNeighbours(fullMap);
    }
  }

  public int getSize() { return points.size(); }
  
}
