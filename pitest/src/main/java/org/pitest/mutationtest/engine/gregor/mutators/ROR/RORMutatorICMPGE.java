
package org.pitest.mutationtest.engine.gregor.mutators.ROR;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractJumpMutator;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public enum RORMutatorICMPGE implements MethodMutatorFactory {

  ROR_MUTATOR_ICMPGE;

  @Override
  public MethodVisitor create(final MutationContext context,
      final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new RORMethodICMPGEVisitor(this, context, methodVisitor);
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

class RORMethodICMPGEVisitor extends AbstractJumpMutator {

    RORMethodICMPGEVisitor(final MethodMutatorFactory factory,
        final MutationContext context, final MethodVisitor delegateMethodVisitor) {
        super(factory, context, delegateMethodVisitor);
  }

  private static final Map<Integer, Substitution> MUTATIONS = new HashMap<Integer, Substitution>();
  private static final String DESCRIPTION = "changed conditional boundary to IF_ICMPGE";

  static {
    MUTATIONS.put(159, new Substitution(Opcodes.IF_ICMPGE, DESCRIPTION));
    MUTATIONS.put(160, new Substitution(Opcodes.IF_ICMPGE, DESCRIPTION));
    MUTATIONS.put(161, new Substitution(Opcodes.IF_ICMPGE, DESCRIPTION));
    MUTATIONS.put(163, new Substitution(Opcodes.IF_ICMPGE, DESCRIPTION));
    MUTATIONS.put(164, new Substitution(Opcodes.IF_ICMPGE, DESCRIPTION));

  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}
