package org.pitest.mutationtest.engine.gregor.mutators.AOD;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.mutators.OpcodeToType;


public class FirstOperandMutator implements MethodMutatorFactory {

    @Override
    public MethodVisitor create(final MutationContext context,
                                final MethodInfo methodInfo, final MethodVisitor methodVisitor)  {
        return new FirstOperandVisitor(this, context, methodInfo, methodVisitor);
    }
    @Override
    public String getGloballyUniqueId()  {
        return this.getClass().getName();
    }
    @Override
    public String toString() {
        return "AOD_FIRST_OPERAND_MUTATOR";
    }

    @Override
    public String getName() {
        return toString();
    }
}

class FirstOperandVisitor extends MethodVisitor  {

    private final MethodMutatorFactory factory;
    private final MutationContext      context;
    private final MethodInfo      info;

    FirstOperandVisitor(final MethodMutatorFactory factory,
                      final MutationContext context, final MethodInfo info, final MethodVisitor delegateMethodVisitor)  {
        super(Opcodes.ASM5, delegateMethodVisitor);
        this.factory = factory;
        this.context = context;
        this.info = info;
    }

    private boolean shouldMutate(String expression) {
        if (info.isGeneratedEnumMethod()) {
            return false;
        } else {
            final MutationIdentifier newId = this.context.registerMutation(
                    this.factory, "AOD: Replaced " + expression + " with first operand");
            return this.context.shouldMutate(newId);
        }

    }

    @Override
    public void visitInsn(int opcode) {
        switch (opcode) {
            case Opcodes.IADD:
            case Opcodes.ISUB:
            case Opcodes.IMUL:
            case Opcodes.IDIV:
            case Opcodes.IREM:

            case Opcodes.FADD:
            case Opcodes.FSUB:
            case Opcodes.FMUL:
            case Opcodes.FDIV:
            case Opcodes.FREM:
                if (this.shouldMutate(OpcodeToType.typeOfOpcode(opcode)))  {
                    mv.visitInsn(Opcodes.POP);
                } else  {
                    mv.visitInsn(opcode);
                }
                break;
            case Opcodes.LADD:
            case Opcodes.LSUB:
            case Opcodes.LMUL:
            case Opcodes.LDIV:
            case Opcodes.LREM:

            case Opcodes.DADD:
            case Opcodes.DSUB:
            case Opcodes.DMUL:
            case Opcodes.DDIV:
            case Opcodes.DREM:
                if (this.shouldMutate(OpcodeToType.typeOfOpcode(opcode)))  {
                    mv.visitInsn(Opcodes.POP2);
                } else  {
                    mv.visitInsn(opcode);
                }
                break;
            default:
                mv.visitInsn(opcode);
                break;
        }
    }
}
