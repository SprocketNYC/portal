package com.themodernway.api.server.ws

import org.codehaus.groovy.transform.GroovyASTTransformation
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.ASTNode

@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
class WSTransform implements ASTTransformation {

    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        def (annotation, klass) = astNodes
        def toMD5 = new AstBuilder().buildFromString(
                """
        import java.security.MessageDigest
        
        class ${klass.name} {
            String toMD5() {
                def md5 = MessageDigest.getInstance('MD5')
                
                md5.update(toString().bytes)
                md5.digest().inject(new StringBuffer()) { sb, it ->
                    sb.append(String.format('%02x', it))
                }.toString()
            }
        }
        """
                )[1].methods[0].find { it.name == 'toMD5' }

        klass.addMethod(toMD5)
    }
}
