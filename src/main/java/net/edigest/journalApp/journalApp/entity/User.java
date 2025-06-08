package net.edigest.journalApp.journalApp.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//pojo
@Document(collection="users")
/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder*/
@Data
@Builder
public class User {
    @Id
    private ObjectId id;
    @NonNull
    @Indexed(unique = true)
    private String userName;// spring.data.mongodb.auto-index-creation=true in app.prop
    @NonNull
    private String password;

     @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();
     private List<String> roles;
}
