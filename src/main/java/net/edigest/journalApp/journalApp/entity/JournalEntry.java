package net.edigest.journalApp.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

//pojo
@Document(collection="journal_entries")
/*@Getter
@Setter

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder*/
@Data
@NoArgsConstructor
public class JournalEntry {
   @Id
   private ObjectId id;// @Id maps as primary key
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;







}
