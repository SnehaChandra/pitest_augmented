
package org.pitest.mutationtest.engine.gregor.mutators;

import java.util.concurrent.Callable;

import org.junit.Before;
import org.junit.Test;
import org.pitest.mutationtest.engine.Mutant;
import org.pitest.mutationtest.engine.gregor.MutatorTestBase;
import org.pitest.mutationtest.engine.gregor.mutators.ROR.RORMutatorICMPEQ;

public class RORMutatorICMPEQTest extends MutatorTestBase {

	@Before
	public void setupEngineToMutateROR() {
		createTesteeWith(RORMutatorICMPEQ.ROR_MUTATOR_ICMPEQ);
	}

	  private static int getZeroButPreventInlining() {
		    return 0;
	  }


	  private static class HasIF_ICMPLE implements Callable<String> {
	    private final int i;

	    HasIF_ICMPLE(final int i) {
	      this.i = i;
	    }

	    @Override
	    public String call() {
	      final int j = getZeroButPreventInlining();
	      if (this.i > j) {
	        return "was > zero";
	      } else {
	        return "was <= zero";
	      }
	    }
	  }

	  @Test
	  public void shouldReplaceICMPLEwithIF_ICMPLT() throws Exception {
	    final Mutant mutant = getFirstMutant(HasIF_ICMPLE.class);
	    assertMutantCallableReturns(new HasIF_ICMPLE(1), mutant, "was > zero");
	    assertMutantCallableReturns(new HasIF_ICMPLE(-1), mutant, "was > zero");
	    assertMutantCallableReturns(new HasIF_ICMPLE(0), mutant, "was <= zero");
	  }

	  private static class HasIF_ICMPGE implements Callable<String> {
	    private final int i;

	    HasIF_ICMPGE(final int i) {
	      this.i = i;
	    }

	    @Override
	    public String call() {
	      final int j = getZeroButPreventInlining();
	      if (this.i < j) {
	        return "was < zero";
	      } else {
	        return "was >= zero";
	      }
	    }
	  }

	  @Test
	  public void shouldReplaceIF_ICMPGEwithIF_ICMPGT() throws Exception {
	    final Mutant mutant = getFirstMutant(HasIF_ICMPGE.class);
	    assertMutantCallableReturns(new HasIF_ICMPGE(-1), mutant, "was < zero");
	    assertMutantCallableReturns(new HasIF_ICMPGE(1), mutant, "was < zero");
	    assertMutantCallableReturns(new HasIF_ICMPGE(0), mutant, "was >= zero");
	  }

	  private static class HasIF_ICMPGT implements Callable<String> {
	    private final int i;

	    HasIF_ICMPGT(final int i) {
	      this.i = i;
	    }

	    @Override
	    public String call() {
	      final int j = getZeroButPreventInlining();
	      if (this.i <= j) {
	        return "was <= zero";
	      } else {
	        return "was > zero";
	      }
	    }
	  }

	  @Test
	  public void shouldReplaceIF_ICMPGTwithIF_ICMPGE() throws Exception {
	    final Mutant mutant = getFirstMutant(HasIF_ICMPGT.class);
	    assertMutantCallableReturns(new HasIF_ICMPGT(-1), mutant, "was <= zero");
	    assertMutantCallableReturns(new HasIF_ICMPGT(1), mutant, "was <= zero");
	    assertMutantCallableReturns(new HasIF_ICMPGT(0), mutant, "was > zero");
	  }

	  private static class HasIF_ICMPLT implements Callable<String> {
	    private final int i;

	    HasIF_ICMPLT(final int i) {
	      this.i = i;
	    }

	    @Override
	    public String call() {
	      final int j = getZeroButPreventInlining();
	      if (this.i >= j) {
	        return "was >= zero";
	      } else {
	        return "was < zero";
	      }
	    }
	  }

	  @Test
	  public void shouldReplaceIF_ICMPLTwithIF_ICMPGT() throws Exception {
	    final Mutant mutant = getFirstMutant(HasIF_ICMPLT.class);
	    assertMutantCallableReturns(new HasIF_ICMPLT(-1), mutant, "was >= zero");
	    assertMutantCallableReturns(new HasIF_ICMPLT(1), mutant, "was >= zero");
	    assertMutantCallableReturns(new HasIF_ICMPLT(0), mutant, "was < zero");
	  }
}
