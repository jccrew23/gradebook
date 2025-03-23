public class Assignment implements Gradable {
    private String _assignmentName;
    private int _pointsAvailable;
    private int _pointsEarned;
    private float _assignmentPercentage;

    public Assignment(String name, int pointsAvailable) {
        _assignmentName = name;
        _pointsAvailable = pointsAvailable;

    }

    @Override
    public float assignmentGrade() {
        return (float) _pointsEarned / _pointsAvailable * 100; // Calculate the percentage of points earned
    }

    public int getPointsEarned() {
        return _pointsEarned;
    }


    public float getPercentage() {
        if (_pointsAvailable == 0) {
            return 0; // Avoid division by zero
        }
        _assignmentPercentage = (float) _pointsEarned / _pointsAvailable * 100;
        return _assignmentPercentage;
    }

    public int getPointsAvailable() {
        return _pointsAvailable;
    }

    public void setPointsEarned(int pointsEarned) {
        if (pointsEarned <= _pointsAvailable && pointsEarned >= 0) {
            _pointsEarned = pointsEarned;
        } else {
            System.out.println("Invalid points earned. Must be between 0 and " + _pointsAvailable);
        }
    }

    public String getName() {
        return _assignmentName;
    }
}