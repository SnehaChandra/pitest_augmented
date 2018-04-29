
package org.pitest.mutationtest.engine.gregor.mutators.ROR;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractJumpMutator;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public enum RORMutatorIFGT implements MethodMutatorFactory {

  ROR_MUTATOR_IFGT;

  @Override
  public MethodVisitor create(final MutationContext context,
      final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new RORMethodIFGTVisitor(this, context, methodVisitor);
  }

  @Override
  public String getGloballyUniqueId() {
    return this.getClass().getName();
  }

  @Override
  public String getName() {
    return name();
  }

}

class RORMethodIFGTVisitor extends AbstractJumpMutator {

    RORMethodIFGTVisitor(final MethodMutatorFactory factory,
        final MutationContext context, final MethodVisitor delegateMethodVisitor) {
        super(factory, context, delegateMethodVisitor);
  }

  private static final Map<Integer, Substitution> MUTATIONS = new HashMap<Integer, Substitution>();
  private static final String DESCRIPTION = "changed conditional boundary to IFGT";

  static {
    MUTATIONS.put(153, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(154, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(155, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(156, new Substitution(Opcodes.IFGT, DESCRIPTION));
    MUTATIONS.put(158, new Substitution(Opcodes.IFGT, DESCRIPTION));

  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}
