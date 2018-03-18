/*
 * Copyright 2017 Naif Alatrash
 */
package org.pitest.mutationtest.engine.gregor.mutators.ROR;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractJumpMutator;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

import java.util.HashMap;
import java.util.Map;

public enum RORMutatorIFNE implements MethodMutatorFactory {

  ROR_MUTATOR_IFNE;

  @Override
  public MethodVisitor create(final MutationContext context,
                              final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new RORMethodIFNEVisitor(this, context, methodVisitor);
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

class RORMethodIFNEVisitor extends AbstractJumpMutator {

    RORMethodIFNEVisitor(final MethodMutatorFactory factory,
                         final MutationContext context, final MethodVisitor delegateMethodVisitor) {
        super(factory, context, delegateMethodVisitor);
  }

  private static final Map<Integer, Substitution> MUTATIONS = new HashMap<Integer, Substitution>();
  private static final String DESCRIPTION = "changed conditional boundary to IFNE";

  static {
    MUTATIONS.put(153, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(155, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(156, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(157, new Substitution(Opcodes.IFNE, DESCRIPTION));
    MUTATIONS.put(158, new Substitution(Opcodes.IFNE, DESCRIPTION));

  }

  @Override
  protected Map<Integer, Substitution> getMutations() {
    return MUTATIONS;
  }

}
