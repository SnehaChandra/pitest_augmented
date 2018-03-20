package org.pitest.mutationtest.engine.gregor.mutators;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.ReferentialComparisonMutator;

import java.util.concurrent.Callable;

public class ReferentialComparisonMutatorTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateROR() {
		createTesteeWith(ReferentialComparisonMutator.REFERENTIAL_COMPARISON_MUTATOR);
	}

	  private static class HasIF_ACMPNE implements Callable<String> {
		    private final Object i;

		    HasIF_ACMPNE(final Object i) {
		      this.i = i;
		    }

		    @Override
		    public String call() {
		      final Object integer = Integer.class;
		      if (this.i == integer) {
		        return "was integer";
		      } else {
		        return "was not integer";
		      }
		    }
		  }

		  @Test
		  public void shouldReplaceIF_ACMPNEWithIF_CMPEQ() throws Exception {
		    final Mutant mutant = getFirstMutant(HasIF_ACMPNE.class);
		    printMutant(mutant);
		    assertMutantCallableReturns(new HasIF_ACMPNE(String.class), mutant,
		        "was integer");
		    assertMutantCallableReturns(new HasIF_ACMPNE(Integer.class), mutant,
		        "was not integer");
		  }

		  private static class HasIF_ACMPEQ implements Callable<String> {
		    private final Object i;

		    HasIF_ACMPEQ(final Object i) {
		      this.i = i;
		    }

		    @Override
		    public String call() {
		      final Object integer = Integer.class;
		      if (this.i != integer) {
		        return "was not integer";
		      } else {
		        return "was integer";
		      }
		    }
		  }

		  @Test
		  public void shouldReplaceIF_ACMPEQWithIF_CMPNE() throws Exception {
		    final Mutant mutant = getFirstMutant(HasIF_ACMPEQ.class);
		    assertMutantCallableReturns(new HasIF_ACMPEQ(String.class), mutant,
		        "was integer");
		    assertMutantCallableReturns(new HasIF_ACMPEQ(Integer.class), mutant,
		        "was not integer");
		  }
}
