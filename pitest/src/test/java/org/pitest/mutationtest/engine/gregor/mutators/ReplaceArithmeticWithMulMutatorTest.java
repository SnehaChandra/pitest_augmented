package org.pitest.mutationtest.engine.gregor.mutators;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;
import org.pitest.mutationtest.engine.gregor.mutators.AOR.ReplaceArithmeticWithMulMutator;

import java.util.concurrent.Callable;


public class ReplaceArithmeticWithMulMutatorTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateOnlyMathFunctions() {	
		createTesteeWith(ReplaceArithmeticWithMulMutator.REPLACE_ARITHMETIC_WITH_MUL_MUTATOR);
	}
	private static class HasIAdd implements Callable<String> {
		private int i;

		HasIAdd(final int i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i+=2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceIntegerAdditionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasIAdd.class);
		assertMutantCallableReturns(new HasIAdd(2), mutant, "4");
		assertMutantCallableReturns(new HasIAdd(20), mutant, "40");
	}

	private static class HasISub implements Callable<String> {
		private int i;

		HasISub(final int i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i-=2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceIntegerSubtractionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasISub.class);
		assertMutantCallableReturns(new HasISub(2), mutant, "4");
		assertMutantCallableReturns(new HasISub(20), mutant, "40");
	}

	private static class HasLAdd implements Callable<String> {
		private long i;

		HasLAdd(final long i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i+=2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceLongAdditionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasLAdd.class);
		assertMutantCallableReturns(new HasLAdd(2), mutant, "4");
		assertMutantCallableReturns(new HasLAdd(20), mutant, "40");
	}

	private static class HasLSub implements Callable<String> {
		private long i;

		HasLSub(final long i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i-=2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceLongSubtractionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasLSub.class);
		assertMutantCallableReturns(new HasLSub(2), mutant, "4");
		assertMutantCallableReturns(new HasLSub(20), mutant, "40");
	}

	private static class HasFAdd implements Callable<String> {
		private float i;

		HasFAdd(final float i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i+=2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceFloatAdditionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasFAdd.class);
		assertMutantCallableReturns(new HasFAdd(2), mutant, "4.0");
		assertMutantCallableReturns(new HasFAdd(20), mutant, "40.0");
	}

	private static class HasFSub implements Callable<String> {
		private float i;

		HasFSub(final float i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i-=2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceFloatSubtractionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasFSub.class);
		assertMutantCallableReturns(new HasFSub(2), mutant, "4.0");
		assertMutantCallableReturns(new HasFSub(20), mutant, "40.0");
	}

	private static class HasDAdd implements Callable<String> {
		private double i;

		HasDAdd(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i+=2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceDoubleAdditionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasDAdd.class);
		assertMutantCallableReturns(new HasDAdd(2), mutant, "4.0");
		assertMutantCallableReturns(new HasDAdd(20), mutant, "40.0");
	}

	private static class HasDSub implements Callable<String> {
		private double i;

		HasDSub(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i-=2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceDoubleSubstrationWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasDSub.class);
		assertMutantCallableReturns(new HasDSub(2), mutant, "4.0");
		assertMutantCallableReturns(new HasDSub(20), mutant, "40.0");
	}
	private static class HasDRem implements Callable<String> {
		private double i;

		HasDRem(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i % 2;
			return "" + this.i;
		}
	}

}
