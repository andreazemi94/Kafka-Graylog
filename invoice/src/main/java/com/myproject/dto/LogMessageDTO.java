/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.myproject.dto;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class LogMessageDTO extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3575190920206156286L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"LogMessageDTO\",\"namespace\":\"com.myproject.dto\",\"fields\":[{\"name\":\"facility\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"source\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"infoLevel\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"level\",\"type\":\"int\"},{\"name\":\"message\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<LogMessageDTO> ENCODER =
      new BinaryMessageEncoder<LogMessageDTO>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<LogMessageDTO> DECODER =
      new BinaryMessageDecoder<LogMessageDTO>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<LogMessageDTO> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<LogMessageDTO> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<LogMessageDTO> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<LogMessageDTO>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this LogMessageDTO to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a LogMessageDTO from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a LogMessageDTO instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static LogMessageDTO fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String facility;
   private java.lang.String source;
   private java.lang.String infoLevel;
   private int level;
   private java.lang.String message;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public LogMessageDTO() {}

  /**
   * All-args constructor.
   * @param facility The new value for facility
   * @param source The new value for source
   * @param infoLevel The new value for infoLevel
   * @param level The new value for level
   * @param message The new value for message
   */
  public LogMessageDTO(java.lang.String facility, java.lang.String source, java.lang.String infoLevel, java.lang.Integer level, java.lang.String message) {
    this.facility = facility;
    this.source = source;
    this.infoLevel = infoLevel;
    this.level = level;
    this.message = message;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return facility;
    case 1: return source;
    case 2: return infoLevel;
    case 3: return level;
    case 4: return message;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: facility = value$ != null ? value$.toString() : null; break;
    case 1: source = value$ != null ? value$.toString() : null; break;
    case 2: infoLevel = value$ != null ? value$.toString() : null; break;
    case 3: level = (java.lang.Integer)value$; break;
    case 4: message = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'facility' field.
   * @return The value of the 'facility' field.
   */
  public java.lang.String getFacility() {
    return facility;
  }


  /**
   * Sets the value of the 'facility' field.
   * @param value the value to set.
   */
  public void setFacility(java.lang.String value) {
    this.facility = value;
  }

  /**
   * Gets the value of the 'source' field.
   * @return The value of the 'source' field.
   */
  public java.lang.String getSource() {
    return source;
  }


  /**
   * Sets the value of the 'source' field.
   * @param value the value to set.
   */
  public void setSource(java.lang.String value) {
    this.source = value;
  }

  /**
   * Gets the value of the 'infoLevel' field.
   * @return The value of the 'infoLevel' field.
   */
  public java.lang.String getInfoLevel() {
    return infoLevel;
  }


  /**
   * Sets the value of the 'infoLevel' field.
   * @param value the value to set.
   */
  public void setInfoLevel(java.lang.String value) {
    this.infoLevel = value;
  }

  /**
   * Gets the value of the 'level' field.
   * @return The value of the 'level' field.
   */
  public int getLevel() {
    return level;
  }


  /**
   * Sets the value of the 'level' field.
   * @param value the value to set.
   */
  public void setLevel(int value) {
    this.level = value;
  }

  /**
   * Gets the value of the 'message' field.
   * @return The value of the 'message' field.
   */
  public java.lang.String getMessage() {
    return message;
  }


  /**
   * Sets the value of the 'message' field.
   * @param value the value to set.
   */
  public void setMessage(java.lang.String value) {
    this.message = value;
  }

  /**
   * Creates a new LogMessageDTO RecordBuilder.
   * @return A new LogMessageDTO RecordBuilder
   */
  public static com.myproject.dto.LogMessageDTO.Builder newBuilder() {
    return new com.myproject.dto.LogMessageDTO.Builder();
  }

  /**
   * Creates a new LogMessageDTO RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new LogMessageDTO RecordBuilder
   */
  public static com.myproject.dto.LogMessageDTO.Builder newBuilder(com.myproject.dto.LogMessageDTO.Builder other) {
    if (other == null) {
      return new com.myproject.dto.LogMessageDTO.Builder();
    } else {
      return new com.myproject.dto.LogMessageDTO.Builder(other);
    }
  }

  /**
   * Creates a new LogMessageDTO RecordBuilder by copying an existing LogMessageDTO instance.
   * @param other The existing instance to copy.
   * @return A new LogMessageDTO RecordBuilder
   */
  public static com.myproject.dto.LogMessageDTO.Builder newBuilder(com.myproject.dto.LogMessageDTO other) {
    if (other == null) {
      return new com.myproject.dto.LogMessageDTO.Builder();
    } else {
      return new com.myproject.dto.LogMessageDTO.Builder(other);
    }
  }

  /**
   * RecordBuilder for LogMessageDTO instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<LogMessageDTO>
    implements org.apache.avro.data.RecordBuilder<LogMessageDTO> {

    private java.lang.String facility;
    private java.lang.String source;
    private java.lang.String infoLevel;
    private int level;
    private java.lang.String message;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.myproject.dto.LogMessageDTO.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.facility)) {
        this.facility = data().deepCopy(fields()[0].schema(), other.facility);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.source)) {
        this.source = data().deepCopy(fields()[1].schema(), other.source);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.infoLevel)) {
        this.infoLevel = data().deepCopy(fields()[2].schema(), other.infoLevel);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.level)) {
        this.level = data().deepCopy(fields()[3].schema(), other.level);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.message)) {
        this.message = data().deepCopy(fields()[4].schema(), other.message);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing LogMessageDTO instance
     * @param other The existing instance to copy.
     */
    private Builder(com.myproject.dto.LogMessageDTO other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.facility)) {
        this.facility = data().deepCopy(fields()[0].schema(), other.facility);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.source)) {
        this.source = data().deepCopy(fields()[1].schema(), other.source);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.infoLevel)) {
        this.infoLevel = data().deepCopy(fields()[2].schema(), other.infoLevel);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.level)) {
        this.level = data().deepCopy(fields()[3].schema(), other.level);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.message)) {
        this.message = data().deepCopy(fields()[4].schema(), other.message);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'facility' field.
      * @return The value.
      */
    public java.lang.String getFacility() {
      return facility;
    }


    /**
      * Sets the value of the 'facility' field.
      * @param value The value of 'facility'.
      * @return This builder.
      */
    public com.myproject.dto.LogMessageDTO.Builder setFacility(java.lang.String value) {
      validate(fields()[0], value);
      this.facility = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'facility' field has been set.
      * @return True if the 'facility' field has been set, false otherwise.
      */
    public boolean hasFacility() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'facility' field.
      * @return This builder.
      */
    public com.myproject.dto.LogMessageDTO.Builder clearFacility() {
      facility = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'source' field.
      * @return The value.
      */
    public java.lang.String getSource() {
      return source;
    }


    /**
      * Sets the value of the 'source' field.
      * @param value The value of 'source'.
      * @return This builder.
      */
    public com.myproject.dto.LogMessageDTO.Builder setSource(java.lang.String value) {
      validate(fields()[1], value);
      this.source = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'source' field has been set.
      * @return True if the 'source' field has been set, false otherwise.
      */
    public boolean hasSource() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'source' field.
      * @return This builder.
      */
    public com.myproject.dto.LogMessageDTO.Builder clearSource() {
      source = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'infoLevel' field.
      * @return The value.
      */
    public java.lang.String getInfoLevel() {
      return infoLevel;
    }


    /**
      * Sets the value of the 'infoLevel' field.
      * @param value The value of 'infoLevel'.
      * @return This builder.
      */
    public com.myproject.dto.LogMessageDTO.Builder setInfoLevel(java.lang.String value) {
      validate(fields()[2], value);
      this.infoLevel = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'infoLevel' field has been set.
      * @return True if the 'infoLevel' field has been set, false otherwise.
      */
    public boolean hasInfoLevel() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'infoLevel' field.
      * @return This builder.
      */
    public com.myproject.dto.LogMessageDTO.Builder clearInfoLevel() {
      infoLevel = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'level' field.
      * @return The value.
      */
    public int getLevel() {
      return level;
    }


    /**
      * Sets the value of the 'level' field.
      * @param value The value of 'level'.
      * @return This builder.
      */
    public com.myproject.dto.LogMessageDTO.Builder setLevel(int value) {
      validate(fields()[3], value);
      this.level = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'level' field has been set.
      * @return True if the 'level' field has been set, false otherwise.
      */
    public boolean hasLevel() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'level' field.
      * @return This builder.
      */
    public com.myproject.dto.LogMessageDTO.Builder clearLevel() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'message' field.
      * @return The value.
      */
    public java.lang.String getMessage() {
      return message;
    }


    /**
      * Sets the value of the 'message' field.
      * @param value The value of 'message'.
      * @return This builder.
      */
    public com.myproject.dto.LogMessageDTO.Builder setMessage(java.lang.String value) {
      validate(fields()[4], value);
      this.message = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'message' field has been set.
      * @return True if the 'message' field has been set, false otherwise.
      */
    public boolean hasMessage() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'message' field.
      * @return This builder.
      */
    public com.myproject.dto.LogMessageDTO.Builder clearMessage() {
      message = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public LogMessageDTO build() {
      try {
        LogMessageDTO record = new LogMessageDTO();
        record.facility = fieldSetFlags()[0] ? this.facility : (java.lang.String) defaultValue(fields()[0]);
        record.source = fieldSetFlags()[1] ? this.source : (java.lang.String) defaultValue(fields()[1]);
        record.infoLevel = fieldSetFlags()[2] ? this.infoLevel : (java.lang.String) defaultValue(fields()[2]);
        record.level = fieldSetFlags()[3] ? this.level : (java.lang.Integer) defaultValue(fields()[3]);
        record.message = fieldSetFlags()[4] ? this.message : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<LogMessageDTO>
    WRITER$ = (org.apache.avro.io.DatumWriter<LogMessageDTO>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<LogMessageDTO>
    READER$ = (org.apache.avro.io.DatumReader<LogMessageDTO>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.facility);

    out.writeString(this.source);

    out.writeString(this.infoLevel);

    out.writeInt(this.level);

    out.writeString(this.message);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.facility = in.readString();

      this.source = in.readString();

      this.infoLevel = in.readString();

      this.level = in.readInt();

      this.message = in.readString();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.facility = in.readString();
          break;

        case 1:
          this.source = in.readString();
          break;

        case 2:
          this.infoLevel = in.readString();
          break;

        case 3:
          this.level = in.readInt();
          break;

        case 4:
          this.message = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










