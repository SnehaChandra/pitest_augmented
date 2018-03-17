package org.pitest.mutationtest.engine.gregor.mutators;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;

import java.util.concurrent.Callable;


public class AORMulMutatorTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateOnlyMathFunctions() {	
		createTesteeWith(AORMulMutator.AORMUL_MUTATOR);
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
	private static class HasIDiv implements Callable<String> {
		private int i;

		HasIDiv(final int i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i / 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceIntegerDivisionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasIDiv.class);
		assertMutantCallableReturns(new HasIDiv(2), mutant, "4");
		assertMutantCallableReturns(new HasIDiv(20), mutant, "40");
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
	public void shouldReplaceIntegerModulusWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasIRem.class);
		assertMutantCallableReturns(new HasIRem(2), mutant, "4");
		assertMutantCallableReturns(new HasIRem(20), mutant, "40");
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
	public void shouldReplaceLongAdditionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasLAdd.class);
		assertMutantCallableReturns(new HasLAdd(2), mutant, "4");
		assertMutantCallableReturns(new HasLAdd(20), mutant, "40");
	}
	private static class HasLDiv implements Callable<String> {
		private long i;

		HasLDiv(final long i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i / 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceLongDivisionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasLDiv.class);
		assertMutantCallableReturns(new HasLDiv(2), mutant, "4");
		assertMutantCallableReturns(new HasLDiv(20), mutant, "40");
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
	public void shouldReplaceLongModulusWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasLRem.class);
		assertMutantCallableReturns(new HasLRem(2), mutant, "4");
		assertMutantCallableReturns(new HasLRem(20), mutant, "40");
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
	public void shouldReplaceFloatAdditionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasFAdd.class);
		assertMutantCallableReturns(new HasFAdd(2), mutant, "4.0");
		assertMutantCallableReturns(new HasFAdd(20), mutant, "40.0");
	}
	private static class HasFDiv implements Callable<String> {
		private float i;

		HasFDiv(final float i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i / 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceFloatDivisionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasFDiv.class);
		assertMutantCallableReturns(new HasFDiv(2), mutant, "4.0");
		assertMutantCallableReturns(new HasFDiv(20), mutant, "40.0");
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
	public void shouldReplaceFloatModulusWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasFRem.class);
		assertMutantCallableReturns(new HasFRem(2), mutant, "4.0");
		assertMutantCallableReturns(new HasFRem(20), mutant, "40.0");
	}
	//double

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

	private static class HasDDiv implements Callable<String> {
		private double i;

		HasDDiv(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i / 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceDoubleDivisionWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasDDiv.class);
		assertMutantCallableReturns(new HasDDiv(2), mutant, "4.0");
		assertMutantCallableReturns(new HasDDiv(20), mutant, "40.0");
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
	@Test
	public void shouldReplaceDoubleModulusWithMultication() throws Exception {
		final Mutant mutant = getFirstMutant(HasDRem.class);
		assertMutantCallableReturns(new HasDRem(2), mutant, "4.0");
		assertMutantCallableReturns(new HasDRem(20), mutant, "40.0");
	}
}
