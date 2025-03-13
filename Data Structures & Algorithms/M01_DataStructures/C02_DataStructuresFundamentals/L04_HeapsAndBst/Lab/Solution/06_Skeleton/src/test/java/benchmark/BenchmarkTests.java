package benchmark;

import implementations.BinarySearchTree;
import implementations.PriorityQueue;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
// Arguments that specify the memory allocation pool
// Xms -> starting memory pool 2GB and Xmx - the maximum memory pool 4GB
// NOTE: When running those tests you may want to adjust those values as well
// as the param value, otherwise -> java.lang.OutOfMemoryError may occur
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx4G"})
@State(Scope.Benchmark)
public class BenchmarkTests {

    @Param({"1000", "10000"/*, "100000000"*/})
    private long n;

    private ArrayList<Long> arrayList = new ArrayList<>();
    private PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
    private BinarySearchTree<Long> binarySearchTree = new BinarySearchTree<>();

    private void fillArrayList(ArrayList<Long> list) {
        for (long i = 0; i < n; i++) {
            list.add(i);
        }
    }

    private void fillPriorityQueue(PriorityQueue<Long> queue) {
        for (long i = 0; i < n; i++) {
            queue.add(i);
        }
    }

    private void fillBST(BinarySearchTree<Long> binarySearchTree) {
        for (long i = 0; i < n; i++) {
            binarySearchTree.insert(i);
        }
    }

    @Setup(Level.Invocation)
    public void setup() {
        this.fillArrayList(arrayList);
        this.fillPriorityQueue(priorityQueue);
        this.fillBST(binarySearchTree);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkTests.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void testAddInArrayList(Blackhole blackhole) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }
    }

    @Benchmark
    public void testAddInPriorityQueue(Blackhole blackhole) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }
    }

    @Benchmark
    public void testAddInBST(Blackhole blackhole) {
        BinarySearchTree<Integer> numbers = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) {
            numbers.insert(i);
        }
    }

    @Benchmark
    public void testFindInArrayListWorstCase() {
        arrayList.indexOf(n + 1);
    }

    @Benchmark
    public void testFindInPriorityQueueWorstCase() {
        // Well to find an element we have to search all the elements here
        while (priorityQueue.size() != 0) {
            priorityQueue.poll();
        }
    }

    @Benchmark
    public void testFindInBinarySearchTreeWorstCase() {
        binarySearchTree.contains(n + 1);
    }
}
