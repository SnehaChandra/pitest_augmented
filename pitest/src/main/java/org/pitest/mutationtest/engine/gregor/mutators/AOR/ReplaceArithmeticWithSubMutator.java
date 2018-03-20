package org.pitest.mutationtest.engine.gregor.mutators.AOR;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractInsnMutator;
import org.pitest.mutationtest.engine.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation;

public enum ReplaceArithmeticWithSubMutator implements MethodMutatorFactory {

  REPLACE_ARITHMETIC_WITH_SUB_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
  final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new ReplaceArithmeticWithSubVisitor(this, methodInfo, context, methodVisitor);
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

class ReplaceArithmeticWithSubVisitor extends AbstractInsnMutator {

  ReplaceArithmeticWithSubVisitor(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<Integer, ZeroOperandMutation>();

  static {
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.ISUB,
            "AOR: Replaced integer multiplication with subtraction"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISUB,
            "AOR: Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.ISUB,
            "AOR: Replaced integer modulus with subtraction"));
    // longs
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LSUB,
            "AOR: Replaced long multiplication with subtraction"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LSUB,
            "AOR: Replaced long division with subtraction"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LSUB,
            "AOR: Replaced long modulus with subtraction"));
    //float
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FSUB,
            "AOR: Replaced float multiplication with subtraction"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FSUB,
            "AOR: Replaced float division with subtraction"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FSUB,
            "AOR: Replaced float modulus with subtraction"));
    //double
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DSUB,
            "AOR: Replaced double multiplication with subtraction"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DSUB,
            "AOR: Replaced double division with subtraction"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DSUB,
            "AOR: Replaced double modulus with subtraction"));
  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}