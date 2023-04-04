package generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import sut.Point2D;

public class Point2DGenerator extends Generator<Point2D> {

	public static final Point2D ORIGIN = new Point2D(0,0);

	public Point2DGenerator() {
		super(Point2D.class);
	}
	
	@Override
	public Point2D generate(SourceOfRandomness src, GenerationStatus status) {  
		return new Point2D(src.nextInt(), src.nextInt());
	}

}
