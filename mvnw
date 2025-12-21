#!/usr/bin/env bash
# -----------------------------------------------------------------------------
# Maven Start Up Batch script
# -----------------------------------------------------------------------------

# Set up directories
WRAPPER_DIR=".mvn/wrapper"
WRAPPER_JAR="$WRAPPER_DIR/maven-wrapper.jar"
WRAPPER_PROPERTIES="$WRAPPER_DIR/maven-wrapper.properties"

# Create directory if it doesn't exist
mkdir -p "$WRAPPER_DIR"

# Download wrapper properties if missing
if [ ! -f "$WRAPPER_PROPERTIES" ]; then
    cat > "$WRAPPER_PROPERTIES" << 'EOF'
distributionUrl=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.9/apache-maven-3.9.9-bin.zip
wrapperUrl=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.2/maven-wrapper-3.3.2.jar
EOF
fi

# Download wrapper jar if missing
if [ ! -f "$WRAPPER_JAR" ]; then
    echo "Downloading Maven wrapper..."
    curl -s -o "$WRAPPER_JAR" \
        https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.2/maven-wrapper-3.3.2.jar
fi

# Execute Java with the wrapper
exec java -classpath "$WRAPPER_JAR" "-Dmaven.multiModuleProjectDirectory=$(pwd)" \
    org.apache.maven.wrapper.MavenWrapperMain "$@"