import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int number_;			  // Vertex number
	private int degrees_;			  // out degrees for vertex
	private boolean processed_;	// vertex has been processed.
	private boolean discovered_;// vertex has been discovered;
	private List<Edge> edges_;	// Edges of this Vertex
	private int entryTime_;			// increment when Vertex is processed early
	private int exitTime_;		  // increment when Vertex is processed late
	private Vertex parent_;			// Vertex parent

	public Vertex(int number) {
		number_ = number;
		processed_ = false;
		discovered_ = false;
		edges_ = new ArrayList<Edge>();
		parent_ = null;
	}

	public void resetStates() {
		processed_ = false;
		discovered_ = false;
		entryTime_ = 0;
		exitTime_ = 0;
	}

	public int        getNumber()          { return number_; }
	public boolean    isProcessed()        { return processed_; }
	public void       setProcessed()       { processed_ = true; }
	public boolean    isDiscovered()       { return discovered_; }
	public void       setDiscovered()      { discovered_ = true; }
	public void       incrementDegrees()   { degrees_ += 1; }
	public int        degreeCount()        { return degrees_; }
	public void       addEdge(Edge e)      { edges_.add(e); }
	public List<Edge> getEdges()           { return edges_; }
	public int        entryTime()          { return entryTime_; }
	public void       incrementEntryTime() { entryTime_++; }
	public int        exitTime()           { return exitTime_; }
	public void       incrementExitTime()  { exitTime_++; }
	public void       setParent(Vertex v)  { parent_ = v; }
	public Vertex     getParent()          { return parent_; }
}
