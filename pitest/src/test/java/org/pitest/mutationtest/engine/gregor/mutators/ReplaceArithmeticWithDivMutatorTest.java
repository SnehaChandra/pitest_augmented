package org.pitest.mutationtest.engine.gregor.mutators;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;
import org.pitest.mutationtest.engine.gregor.mutators.AOR.ReplaceArithmeticWithDivMutator;

import java.util.concurrent.Callable;

public class ReplaceArithmeticWithDivMutatorTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateOnlyMathFunctions() {	
		createTesteeWith(ReplaceArithmeticWithDivMutator.REPLACE_ARITHMETIC_WITH_DIV_MUTATOR);
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
	public void shouldReplaceIntegerAdditionWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasIAdd.class);
		assertMutantCallableReturns(new HasIAdd(2), mutant, "1");
		assertMutantCallableReturns(new HasIAdd(20), mutant, "10");
	}
	private static class HasIMul implements Callable<String> {
		private int i;

		HasIMul(final int i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i * 2;
			return "" + this.i;
		}
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
	public void shouldReplaceIntegerSubtractionWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasISub.class);
		assertMutantCallableReturns(new HasISub(2), mutant, "1");
		assertMutantCallableReturns(new HasISub(20), mutant, "10");
	}
	private static class HasIRem implements Callable<String> {
		private int i;

		HasIRem(final int i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i % 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceIntegerModulusWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasIRem.class);
		assertMutantCallableReturns(new HasIRem(2), mutant, "1");
		assertMutantCallableReturns(new HasIRem(20), mutant, "10");
	}

	//long

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
	public void shouldReplaceLongAdditionWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasLAdd.class);
		assertMutantCallableReturns(new HasLAdd(2), mutant, "1");
		assertMutantCallableReturns(new HasLAdd(20), mutant, "10");
	}
	private static class HasLMul implements Callable<String> {
		private long i;

		HasLMul(final long i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i * 2;
			return "" + this.i;
		}
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
	public void shouldReplaceLongSubtractionWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasLSub.class);
		assertMutantCallableReturns(new HasLSub(2), mutant, "1");
		assertMutantCallableReturns(new HasLSub(20), mutant, "10");
	}
	private static class HasLRem implements Callable<String> {
		private long i;

		HasLRem(final long i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i % 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceLongModulusWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasLRem.class);
		assertMutantCallableReturns(new HasLRem(2), mutant, "1");
		assertMutantCallableReturns(new HasLRem(20), mutant, "10");
	}
	//float

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
	public void shouldReplaceFloatAdditionWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasFAdd.class);
		assertMutantCallableReturns(new HasFAdd(2), mutant, "1.0");
		assertMutantCallableReturns(new HasFAdd(20), mutant, "10.0");
	}
	private static class HasFMul implements Callable<String> {
		private float i;

		HasFMul(final float i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i * 2;
			return "" + this.i;
		}
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
	public void shouldReplaceFloatSubtractionWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasFSub.class);
		assertMutantCallableReturns(new HasFSub(2), mutant, "1.0");
		assertMutantCallableReturns(new HasFSub(20), mutant, "10.0");
	}
	private static class HasFRem implements Callable<String> {
		private float i;

		HasFRem(final float i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i % 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceFloatModulusWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasFRem.class);
		assertMutantCallableReturns(new HasFRem(2), mutant, "1.0");
		assertMutantCallableReturns(new HasFRem(20), mutant, "10.0");
	}
	//double

	private static class HasDMul implements Callable<String> {
		private double i;

		HasDMul(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i * 2;
			return "" + this.i;
		}
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
	public void shouldReplaceDoubleAdditionWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasDAdd.class);
		assertMutantCallableReturns(new HasDAdd(2), mutant, "1.0");
		assertMutantCallableReturns(new HasDAdd(20), mutant, "10.0");
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
	public void shouldReplaceDoubleSubstrationWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasDSub.class);
		assertMutantCallableReturns(new HasDSub(2), mutant, "1.0");
		assertMutantCallableReturns(new HasDSub(20), mutant, "10.0");
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
	@Test
	public void shouldReplaceDoubleModulusWithDivision() throws Exception {
		final Mutant mutant = getFirstMutant(HasDRem.class);
		assertMutantCallableReturns(new HasDRem(2), mutant, "1.0");
		assertMutantCallableReturns(new HasDRem(20), mutant, "10.0");
	}
}
