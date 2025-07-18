import java.util.List;

public class MazeRsult {
    private List<Cell> path;
    private boolean found;

    public MazeRsult(List<Cell> path, boolean found) {
        this.path = path;
        this.found = found;
    }

    public List<Cell> getPath() {
        return path;
    }

    public boolean isFound() {
        return found;
    }

    @Override
    public String toString() {
        return "MazeRsult{" +
                "path=" + path +
                ", found=" + found +
                '}';
    }
}
