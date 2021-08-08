package xyz.auriium.branch.adventure;

import net.kyori.adventure.audience.Audience;

/**
 * I am not one to be outdone with names
 */
public interface AudienceTransmogrifier<A> {

    Audience transmogrify(A user);

}
