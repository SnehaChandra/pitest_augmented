package org.pitest.mutationtest.engine.gregor.mutators;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;
import org.pitest.mutationtest.engine.gregor.mutators.AOR.ReplaceArithmeticWithAddMutator;

import java.util.concurrent.Callable;


public class ReplaceArithmeticWithAddMutatorTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateOnlyMathFunctions() {	
		createTesteeWith(ReplaceArithmeticWithAddMutator.REPLACE_ARITHMETIC_WITH_ADD_MUTATOR);
	}
	private static class HasISub implements Callable<String> {
		private int i;

		HasISub(final int i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i--;
			return "" + this.i;
		}
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
	public void shouldReplaceIntegerMulticationWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasIMul.class);
		assertMutantCallableReturns(new HasIMul(1), mutant, "3");
		assertMutantCallableReturns(new HasIMul(20), mutant, "22");
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
	public void shouldReplaceIntegerDivisionWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasIDiv.class);
		assertMutantCallableReturns(new HasIDiv(1), mutant, "3");
		assertMutantCallableReturns(new HasIDiv(20), mutant, "22");
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
	public void shouldReplaceIntegerModulusWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasIRem.class);
		assertMutantCallableReturns(new HasIRem(1), mutant, "3");
		assertMutantCallableReturns(new HasIRem(20), mutant, "22");
	}

	//long

	private static class HasLSub implements Callable<String> {
		private long i;

		HasLSub(final long i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i--;
			return "" + this.i;
		}
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
	public void shouldReplaceLongMulticationWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasLMul.class);
		assertMutantCallableReturns(new HasLMul(1), mutant, "3");
		assertMutantCallableReturns(new HasLMul(20), mutant, "22");
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
	public void shouldReplaceLongDivisionWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasLDiv.class);
		assertMutantCallableReturns(new HasLDiv(1), mutant, "3");
		assertMutantCallableReturns(new HasLDiv(20), mutant, "22");
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
	public void shouldReplaceLongModulusWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasLRem.class);
		assertMutantCallableReturns(new HasLRem(1), mutant, "3");
		assertMutantCallableReturns(new HasLRem(20), mutant, "22");
	}
	//float

	private static class HasFSub implements Callable<String> {
		private float i;

		HasFSub(final float i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i--;
			return "" + this.i;
		}
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
	public void shouldReplaceFloatMulticationWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasFMul.class);
		assertMutantCallableReturns(new HasFMul(1), mutant, "3.0");
		assertMutantCallableReturns(new HasFMul(20), mutant, "22.0");
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
	public void shouldReplaceFloatDivisionWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasFDiv.class);
		assertMutantCallableReturns(new HasFDiv(1), mutant, "3.0");
		assertMutantCallableReturns(new HasFDiv(20), mutant, "22.0");
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
	public void shouldReplaceFloatModulusWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasFRem.class);
		assertMutantCallableReturns(new HasFRem(1), mutant, "3.0");
		assertMutantCallableReturns(new HasFRem(20), mutant, "22.0");
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
	public void shouldReplaceDoubleMulticationWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasDMul.class);
		assertMutantCallableReturns(new HasDMul(1), mutant, "3.0");
		assertMutantCallableReturns(new HasDMul(20), mutant, "22.0");
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
	public void shouldReplaceDoubleDivisionWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasDDiv.class);
		assertMutantCallableReturns(new HasDDiv(1), mutant, "3.0");
		assertMutantCallableReturns(new HasDDiv(20), mutant, "22.0");
	}
	private static class HasDSub implements Callable<String> {
		private double i;

		HasDSub(final double i) {
			this.i = i;
		}

		@Override
		public String call() {
			this.i--;
			return "" + this.i;
		}
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
	public void shouldReplaceDoubleModulusWithAddition() throws Exception {
		final Mutant mutant = getFirstMutant(HasDRem.class);
		assertMutantCallableReturns(new HasDRem(1), mutant, "3.0");
		assertMutantCallableReturns(new HasDRem(20), mutant, "22.0");
	}
}
