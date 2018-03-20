package org.pitest.mutationtest.engine.gregor.mutators;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;
import org.pitest.mutationtest.engine.gregor.mutators.AOR.ReplaceArithmeticWithRemMutator;

import java.util.concurrent.Callable;


public class ReplaceArithmeticWithRemMutatorTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateOnlyMathFunctions() {	
		createTesteeWith(ReplaceArithmeticWithRemMutator.REPLACE_ARITHMETIC_WITH_REM_MUTATOR);
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
	public void shouldReplaceIntegerAdditionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasIAdd.class);
		assertMutantCallableReturns(new HasIAdd(2), mutant, "0");
		assertMutantCallableReturns(new HasIAdd(21), mutant, "1");
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
	public void shouldReplaceIntegerDivisionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasIDiv.class);
		assertMutantCallableReturns(new HasIDiv(2), mutant, "0");
		assertMutantCallableReturns(new HasIDiv(21), mutant, "1");
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
	public void shouldReplaceIntegerSubtractionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasISub.class);
		assertMutantCallableReturns(new HasISub(4), mutant, "0");
		assertMutantCallableReturns(new HasISub(21), mutant, "1");
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
	@Test
	public void shouldReplaceIntegerMulticationWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasIMul.class);
		assertMutantCallableReturns(new HasIMul(2), mutant, "0");
		assertMutantCallableReturns(new HasIMul(21), mutant, "1");
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
	public void shouldReplaceLongAdditionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasLAdd.class);
		assertMutantCallableReturns(new HasLAdd(2), mutant, "0");
		assertMutantCallableReturns(new HasLAdd(21), mutant, "1");
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
	public void shouldReplaceLongDivisionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasLDiv.class);
		assertMutantCallableReturns(new HasLDiv(2), mutant, "0");
		assertMutantCallableReturns(new HasLDiv(21), mutant, "1");
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
	public void shouldReplaceLongSubtractionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasLSub.class);
		assertMutantCallableReturns(new HasLSub(4), mutant, "0");
		assertMutantCallableReturns(new HasLSub(21), mutant, "1");
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
	@Test
	public void shouldReplaceLongMulticationWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasLMul.class);
		assertMutantCallableReturns(new HasLMul(2), mutant, "0");
		assertMutantCallableReturns(new HasLMul(21), mutant, "1");
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
	public void shouldReplaceFloatAdditionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasFAdd.class);
		assertMutantCallableReturns(new HasFAdd(2), mutant, "0.0");
		assertMutantCallableReturns(new HasFAdd(21), mutant, "1.0");
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
	public void shouldReplaceFloatDivisionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasFDiv.class);
		assertMutantCallableReturns(new HasFDiv(2), mutant, "0.0");
		assertMutantCallableReturns(new HasFDiv(21), mutant, "1.0");
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
	public void shouldReplaceFloatSubtractionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasFSub.class);
		assertMutantCallableReturns(new HasFSub(2), mutant, "0.0");
		assertMutantCallableReturns(new HasFSub(21), mutant, "1.0");
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
	@Test
	public void shouldReplaceFloatMulticationWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasFMul.class);
		assertMutantCallableReturns(new HasFMul(2), mutant, "0.0");
		assertMutantCallableReturns(new HasFMul(21), mutant, "1.0");
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
	@Test
	public void shouldReplaceDoubleMulticationWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasDMul.class);
		assertMutantCallableReturns(new HasDMul(2), mutant, "0.0");
		assertMutantCallableReturns(new HasDMul(21), mutant, "1.0");
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
	public void shouldReplaceDoubleAdditionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasDAdd.class);
		assertMutantCallableReturns(new HasDAdd(2), mutant, "0.0");
		assertMutantCallableReturns(new HasDAdd(21), mutant, "1.0");
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
	public void shouldReplaceDoubleSubstrationWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasDSub.class);
		assertMutantCallableReturns(new HasDSub(2), mutant, "0.0");
		assertMutantCallableReturns(new HasDSub(21), mutant, "1.0");
	}
	private static class HasDRem implements Callable<String> {
		private double i;

		HasDRem(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i = i / 2;
			return "" + this.i;
		}
	}
	@Test
	public void shouldReplaceDoubleDivisionWithModulus() throws Exception {
		final Mutant mutant = getFirstMutant(HasDRem.class);
		assertMutantCallableReturns(new HasDRem(2), mutant, "0.0");
		assertMutantCallableReturns(new HasDRem(21), mutant, "1.0");
	}
}
