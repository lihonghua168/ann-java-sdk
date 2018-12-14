package annchain.genesis.sdk.core.protocol.core.methods.response;

import annchain.genesis.sdk.core.protocol.ObjectMapperFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectReader;
import annchain.genesis.sdk.core.protocol.core.Response;

import java.io.IOException;
import java.util.Optional;

/**
 * eth_getTransactionReceipt.
 */
public class GenGetTransactionReceipt extends Response<TransactionReceipt> {

    public Optional<TransactionReceipt> getTransactionReceipt() {
        return Optional.ofNullable(getResult());
    }

    public static class ResponseDeserialiser extends JsonDeserializer<TransactionReceipt> {

        private ObjectReader objectReader = ObjectMapperFactory.getObjectReader();

        @Override
        public TransactionReceipt deserialize(
                JsonParser jsonParser,
                DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.getCurrentToken() != JsonToken.VALUE_NULL) {
                return objectReader.readValue(jsonParser, TransactionReceipt.class);
            } else {
                return null;  // null is wrapped by Optional in above getter
            }
        }
    }
}
