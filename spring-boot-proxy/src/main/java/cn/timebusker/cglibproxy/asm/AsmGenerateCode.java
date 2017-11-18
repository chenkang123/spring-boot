package cn.timebusker.cglibproxy.asm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AsmGenerateCode {

	public static void main(String[] args) {

		ClassWriter classWriter = new ClassWriter(0);

		classWriter.visit(Opcodes.V1_8, // jdk版本
				Opcodes.ACC_PUBLIC, // 类修饰符
				"Programmer", // 类的全线名
				null, // 签名
				"java/lang/Object", // 父类
				null);// 实现的接口

		// 创建构造函数
		MethodVisitor visitMethod = classWriter.visitMethod(Opcodes.ACC_PUBLIC, // 方法修饰符,
				"<init>", "()V", null, null);

		visitMethod.visitCode();
		visitMethod.visitVarInsn(Opcodes.AALOAD, 0);
		visitMethod.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
		visitMethod.visitInsn(Opcodes.RETURN);
		visitMethod.visitMaxs(1, 1);
		visitMethod.visitEnd();
		MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "code", "()V", null, null);
		methodVisitor.visitCode();
		methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		methodVisitor.visitLdcInsn("I'm a Programmer,Just Coding.....");
		methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
		methodVisitor.visitInsn(Opcodes.RETURN);
		methodVisitor.visitMaxs(2, 2);
		methodVisitor.visitEnd();
		classWriter.visitEnd();
		// 使classWriter类已经完成
		// 将classWriter转换成字节数组写到文件里面去
		byte[] data = classWriter.toByteArray();
		File file = new File("/Users/chenkang/Desktop/Programmer.class");
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(file);
			fout.write(data);
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
